import java.io.InputStream;
import java.io.OutputStream;

public class SnakeView implements SnakeViewInterface{
    private InputStream inputStream;
    private OutputStream outputStream;

    public SnakeView(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void initialize() {
        // Initialize the view
    }

    @Override
    public void render() {
        // Render the game state
    }
}