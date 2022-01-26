import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.plaf.LayerUI;

public class BlurLayerUI extends LayerUI<Component> {

    private BufferedImage mOffscreenImage;
    private final BufferedImageOp mOperation;

    public BlurLayerUI() {
//        int blurValue = 6;
        int blurValue = 12;
        int blurCount = blurValue*blurValue;
        float ninth = 1.0f / blurCount;
        float[] blurKernel = new float[blurCount];
        for(int i=0; i<blurCount; i++) {
            blurKernel[i] = ninth;
        }
        mOperation = new ConvolveOp(new Kernel(blurValue, blurValue, blurKernel), ConvolveOp.EDGE_NO_OP, null);
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        int w = c.getWidth();
        int h = c.getHeight();
        if(w == 0 || h == 0) {
            return;
        }
        // only create the offscreen image if the one we have is the wrong size.
        if(mOffscreenImage == null ||  mOffscreenImage.getWidth() != w ||  mOffscreenImage.getHeight() != h) {
            mOffscreenImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D ig2 = mOffscreenImage.createGraphics();
        ig2.setClip(g.getClip());
        super.paint(ig2, c);
        ig2.dispose();
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(mOffscreenImage, mOperation, 0, 0);
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



}