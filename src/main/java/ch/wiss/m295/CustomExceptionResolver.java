package ch.wiss.m295;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolationException;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError( final Throwable ex, final DataFetchingEnvironment env) {
        if (ex instanceof ConstraintViolationException cve) {
            final List<String> errors = cve.getConstraintViolations()
                .stream()
                .map(cv -> cv.getPropertyPath() + ": " + cv.getMessage())
                .collect(Collectors.toList());

            return GraphqlErrorBuilder.newError(env)
                .message(String.format("Validation failed: %s", String.join(", ", errors)))
                .errorType(ErrorType.BAD_REQUEST)
                .path(env.getExecutionStepInfo().getPath())
                .build();
        } else if (ex instanceof RuntimeException rnfe) {
            
            return GraphqlErrorBuilder.newError(env)
                .message(rnfe.getMessage())
                .errorType(ErrorType.NOT_FOUND)
                .path(env.getExecutionStepInfo().getPath())
                .build();
        }

        return null;
    }
    
}
