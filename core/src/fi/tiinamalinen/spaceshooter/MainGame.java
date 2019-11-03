package fi.tiinamalinen.spaceshooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class MainGame implements ApplicationListener {
	SpriteBatch batch;
	OrthographicCamera camera;

	private Sound crashSound;
	private Music backgroundMusic;
	private Texture background;

    Spaceship voyager;
    ArrayList<Alien> aliens;
    ArrayList<Bullet> bullets;
    //Bullet bullet;
	
	@Override
	public void create () {

		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho( false,10,10);

		background = new Texture(Gdx.files.internal("astronomy.jpg"));

		crashSound = Gdx.audio.newSound(Gdx.files.internal("collide.mp3"));
		//backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("AShamaluev.mp3"));
        //backgroundMusic.setLooping(true);
        //backgroundMusic.play();

        voyager = new Spaceship();
        bullets = new ArrayList<Bullet>();

        aliens = new ArrayList<Alien>();
        for(int i=0; i<5; i++) {
            aliens.add(new Alien());
        }

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

        batch.draw(background, 0, 0, 10, 10);

        voyager.move(camera);
        for(int i=0; i<aliens.size(); i++) {
            Alien x = aliens.get(i);
            x.move();
            x.draw(batch);
            if(voyager.collidesWith(x)) {
                crashSound.play();
            }
            for(int j=0; j<bullets.size(); j++) {
                Bullet b = bullets.get(j);
                if (b.collidesWith(x) && b.getVisible()) {
                    aliens.remove(x);
                    b.setVisible(false);
                }
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet());
            Bullet b = bullets.get(bullets.size() -1);
            b.setRotation(voyager.getRotation());
            b.setX(voyager.getX());
            b.setY(voyager.getY());
            b.setVisible(true);
        }

        for(int j=0; j<bullets.size(); j++) {
            Bullet b = bullets.get(j);
            b.move();
            b.draw(batch);
        }

        voyager.draw(batch);

		batch.end();

	}

	public void resize (int width, int height) {
	}

	public void pause () {
	}

	public void resume () {
	}

	@Override
	public void dispose () {
		batch.dispose();
		crashSound.dispose();
		background.dispose();
		//backgroundMusic.dispose();
	}
}
