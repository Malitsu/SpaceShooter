package fi.tiinamalinen.spaceshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameObject {

    private Texture object;
    private Rectangle objectRectangle;
    private float rotation = 0;

    public Rectangle getRectangle() {
        return objectRectangle;
    }

    public Texture getTexture() {
        return object;
    }

    public void setTexture(String path) {
        this.object = new Texture(Gdx.files.internal(path));
    }

    public void setObjectRectangle(float x, float y) {
        objectRectangle = new Rectangle(x, y,
                object.getWidth() / 500.0f,
                object.getHeight() / 500.0f);
    }

    public float getX() {
        return objectRectangle.x;
    }

    public float getY() {
        return objectRectangle.y;
    }

    public void setX(float x) {
        objectRectangle.x = x;
    }

    public void setY(float y) {
        objectRectangle.y = y;
    }

    public float getWidth() {
        return objectRectangle.width;
    }

    public float getHeight() {
        return objectRectangle.height;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void move() {}

    public void draw(SpriteBatch batch) {
        batch.draw(getTexture(), getX(), getY(), getWidth(), getHeight());
    }

    public boolean collidesWith(Alien ufo) {
        if (getRectangle().overlaps(ufo.getRectangle())) {
            return true;
        } else {
            return false;
        }
    }

}
