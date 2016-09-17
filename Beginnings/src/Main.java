import com.cryotech.GridGraphics;

public class Main {

    public static void main(String[] args) {
        GridGraphics a = new GridGraphics(9, 15, ' ');

        a.SetBox(0, 0, a.GetR() - 1, a.GetC() - 1, '*');
        a.SetBox(1, 1, a.GetR() - 2, a.GetC() - 2, ' ');

        a.SetChar(a.GetR() / 2 - 1, a.GetC() / 2, '-');
        a.SetChar(a.GetR() / 2 + 1, a.GetC() / 2, '-');

        a.SetString(a.GetR() / 2, 3, "Hi Quinn!");
        a.Draw();
    }
}
