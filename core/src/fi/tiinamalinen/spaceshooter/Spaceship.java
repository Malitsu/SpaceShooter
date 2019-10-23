package fi.tiinamalinen.spaceshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Spaceship extends GameObject {

    Spaceship() {
        setTexture("spaceship.png");
        setObjectRectangle(0, 0);
    }

    public void move(OrthographicCamera camera) {

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setRotation(getRotation() - 100 * Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setRotation(getRotation() + 100 * Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            setX((float)(getX() - 0.1f * Math.sin( Math.toRadians( getRotation() ))));
            setY((float)(getY() + 0.1f * Math.cos( Math.toRadians( getRotation() ))));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            setX((float)(getX() + 0.1f * Math.sin( Math.toRadians( getRotation() ))));
            setY((float)(getY() - 0.1f * Math.cos( Math.toRadians( getRotation() ))));
        }

        if(Gdx.input.isTouched()) {
            int realX = Gdx.input.getX();
            int realY = Gdx.input.getY();
            Vector3 touchPos = new Vector3(realX, realY, 0);
            camera.unproject(touchPos);
            setX(touchPos.x);
            setX(touchPos.y);
        }

    }

    public void draw(SpriteBatch batch) {
        batch.draw(getTexture(), getX(), getY(), getWidth()/2f, getHeight()/2f, getWidth(), getHeight(), 1, 1, getRotation(), (int)getX(), (int)getY(), (int)(getWidth()*500), (int)(getHeight()*500), false, false);
    }

}