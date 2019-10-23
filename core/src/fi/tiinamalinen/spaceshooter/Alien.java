package fi.tiinamalinen.spaceshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class Alien extends GameObject {

        private int alienSpeedX;
    private int alienSpeedY;

    Alien() {
        setTexture("alien.png");
        setObjectRectangle(MathUtils.random(0f, 10f), MathUtils.random(0f, 10f));
        alienSpeedX = MathUtils.random(0, 10);
        alienSpeedY = MathUtils.random(0, 10);
    }

    public void move() {
        if (getRectangle().x <= 0) {
            alienSpeedX = MathUtils.random(0, 10);
        }
        else if (getRectangle().x >= (10-getRectangle().height)) {
            alienSpeedX = MathUtils.random(-10, 0);
        }
        if (getRectangle().y <= 0) {
            alienSpeedY = MathUtils.random(0, 10);
        }
        else if (getRectangle().y >= (10-getRectangle().width)) {
            alienSpeedY = MathUtils.random(-10, 0);
        }

        getRectangle().y = getRectangle().y + (alienSpeedY * Gdx.graphics.getDeltaTime());
        getRectangle().x = getRectangle().x + (alienSpeedX * Gdx.graphics.getDeltaTime());
    }

}
