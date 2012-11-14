package net.dynamichorizons.rp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

public class ValidationError
    implements Serializable
{

    private static final long serialVersionUID = 2190556348807000522L;

    private String field;

    private String message;

    public ValidationError() {
    }
    
    public ValidationError( String field, String message )
    {
        this.field = field;
        this.message = message;
    }

    public String getField()
    {
        return field;
    }

    public void setField( String field )
    {
        this.field = field;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }
    
    public static <T> List<ValidationError> fromConstraintViolations(Set<ConstraintViolation<T>> constraintViolations) {
        List<ValidationError> validationErrors = new ArrayList<ValidationError>();
        
        for(ConstraintViolation<T> violation: constraintViolations) {
            validationErrors.add( fromConstraintViolation( violation ) );
        }
        
        return validationErrors;
    }
    
    public static <T> ValidationError fromConstraintViolation(ConstraintViolation<T> constraintViolation) {
        return new ValidationError( constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage() );
    }
    
}
