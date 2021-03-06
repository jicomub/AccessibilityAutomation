package com.experitest.accessibility;

import ng.joey.lib.java.google.vision.Vision;
import org.w3c.dom.Document;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Section {
    private Document dump;
    private BufferedImage image;
    private BufferedImage image2;
    private ArrayList<Element> elements = new ArrayList<>();
    private ArrayList<Issue> issues = new ArrayList<>();
    private Vision.Response visionResponse = null;

    public Vision.Response getVisionResponse() {
        return visionResponse;
    }

    public void setVisionResponse(Vision.Response visionResponse) {
        this.visionResponse = visionResponse;
    }

    public ArrayList<Issue> getIssues() {
        return issues;
    }

    public Document getDump() {
        return dump;
    }

    public void setDump(Document dump) {
        this.dump = dump;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public BufferedImage getImage2() {
        return image2;
    }

    public void setImage2(BufferedImage image2) {
        this.image2 = image2;
    }

    public void draw(File file) throws IOException {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.red);

        for(int i = 0; i < elements.size(); i++){
            Element element = elements.get(i);

            Stroke oldStroke = g2d.getStroke();
            g2d.setStroke(new BasicStroke(2));

            g2d.drawRect(element.getX() + 1, element.getY() + 1, element.getW() - 2, element.getH() - 2);
            g2d.setStroke(oldStroke);
            Font newFont = new Font ("Courier New", Font.BOLD, 20);
            g2d.setFont(newFont);
            g2d.drawString("" + (i + 1), element.getX() + 10, element.getY() + 40);
        }

        g2d.dispose();
        ImageIO.write(image, "PNG", file);
    }

}
