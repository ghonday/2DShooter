package TopDown;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Menu {

    private String start;
    private String exit;

    public Menu() {
        start = "Start";
        exit = "Exit";
    }

    public void render(Graphics2D g){
        Font font = new Font("Arial", Font.BOLD, 70);
        Shape outlineStart = font.createGlyphVector(g.getFontMetrics().getFontRenderContext(), start).getOutline();
        AffineTransform transformStart = AffineTransform.getTranslateInstance(
                -outlineStart.getBounds().getX() + Game.WIDTH/2 - outlineStart.getBounds().width / 2,
                250);
        outlineStart = transformStart.createTransformedShape(outlineStart);
        g.fill(outlineStart);

        Shape outlineExit = font.createGlyphVector(g.getFontMetrics().getFontRenderContext(), exit).getOutline();
        AffineTransform transformExit = AffineTransform.getTranslateInstance(
                -outlineExit.getBounds().getX() + Game.WIDTH/2 - outlineExit.getBounds().width / 2,
                400);
        outlineExit = transformExit.createTransformedShape(outlineExit);
        g.fill(outlineExit);
    }
}
