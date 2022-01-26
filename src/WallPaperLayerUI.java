
import java.awt.AWTEvent;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.plaf.LayerUI;

class WallPaperLayerUI extends LayerUI<JComponent> {
    
  Color firstColor = new Color(204,204,204);
  Color secondColor = new Color(0,0,0);
  @Override
  public void paint(Graphics g, JComponent c) {
    super.paint(g, c);

    Graphics2D g2 = (Graphics2D) g.create();

    int w = c.getWidth();
    int h = c.getHeight();
    g2.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, .5f));
    g2.setPaint(new GradientPaint(0, 0, firstColor, 0, h, secondColor));
    g2.fillRect(0, 0, w, h);

    g2.dispose();
  }

   @Override
        public void installUI(JComponent c) {
            super.installUI(c);
            JLayer jlayer = (JLayer)c;
            jlayer.setLayerEventMask(
                    AWTEvent.MOUSE_EVENT_MASK |
                    AWTEvent.KEY_EVENT_MASK 
                    );

        }

        @Override
        public void uninstallUI(JComponent c) {
            JLayer jlayer = (JLayer)c;
            jlayer.setLayerEventMask(0);
            super.uninstallUI(c);
        }


        @Override
        protected void processMouseEvent(MouseEvent e, JLayer l) {
            e.consume();
        }





        @Override
        protected void processKeyEvent(KeyEvent e,
                JLayer<? extends JComponent> l) {
            e.consume();
        }

}