package src;

import java.io.IOException;

public class Tesla extends StocksData {
    public Tesla() throws IOException {
        super();
    }

    @Override
    public String getName() {
        return "Tesla";
    }
}
