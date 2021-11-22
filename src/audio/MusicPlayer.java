package audio;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Clase que se encarga de reproducir la musica del juego.
 */
public class MusicPlayer implements Runnable {
	
	protected Thread musicThread;
	protected String path;
	protected boolean playing;
	private Clip clip;
	
	public MusicPlayer(String path) {
		this.path = path;
		playing = false;
	}
	
	/**
	 * Inicia la reproduccion de la musica.
	 */
	public void start() {
		playing = true;
		musicThread = new Thread(this);
		musicThread.start();
	}
	
	/**
	 * Detiene la reproduccion de la musica.
	 */
	public void stop() {
		playing = false;
		clip.stop();
		musicThread.interrupt();
	}
	
	/**
	 * Retorna si este reproductor esta activo o no.
	 * @return True si este reproductor esta activo, false si no.
	 */
	public boolean isPlaying() {
		return playing;
	}
	
	@Override
	public void run() {
		try {
			
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(MusicPlayer.class.getResource(path));
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
