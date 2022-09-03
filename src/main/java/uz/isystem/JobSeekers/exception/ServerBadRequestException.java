package uz.isystem.JobSeekers.exception;

public class ServerBadRequestException extends RuntimeException{
    public ServerBadRequestException(String message){
        super(message);
    }
}
