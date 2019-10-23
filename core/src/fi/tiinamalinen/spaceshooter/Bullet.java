package fi.tiinamalinen.spaceshooter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet extends GameObject {

    private boolean visible = false;

    Bullet() {
        setTexture("bullet.png");
        setObjectRectangle(0, 0);
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(getTexture(), getX(), getY(), getWidth()/2f, getHeight()/2f, getWidth(), getHeight(), 1, 1, getRotation(), (int)getX(), (int)getY(), (int)(getWidth()*500), (int)(getHeight()*500), false, false);
    }

    public void move() {
        getRectangle().x -= 0.1f * Math.sin( Math.toRadians( getRotation() ));
        getRectangle().y += 0.1f * Math.cos( Math.toRadians( getRotation() ));
    }

}
