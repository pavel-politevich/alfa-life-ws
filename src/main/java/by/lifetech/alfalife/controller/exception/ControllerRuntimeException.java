package by.lifetech.alfalife.controller.exception;

public class ControllerRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ControllerRuntimeException() {
        super();
    }

    public ControllerRuntimeException(String message) {
        super(message);
    }

    public ControllerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerRuntimeException(Throwable cause) {
        super(cause);
    }
}
