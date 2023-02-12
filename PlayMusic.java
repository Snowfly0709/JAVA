package stu.xjtu.Leon.ToObject.exams;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class PlayMusic implements Runnable {
        String musicName;
        Thread threadPlay;
        AudioClip clip = null;
        public PlayMusic(){
            threadPlay = new Thread(this);
        }
        public void run() {
            clip.play();
        }
        public void playMusic(){
            threadPlay = new Thread(this);
            try{
                threadPlay.start();
            }
            catch(Exception exp) {}
        }
        public void setClipFile(String name){
            musicName = name;
            if(musicName == null)
                musicName = "C:\\Users\\xiongzf\\IdeaProjects\\Basic_Data\\day01\\src\\stu\\xjtu\\Leon\\ToObject\\exams\\mine.wav";
            File file=new File(musicName);
            try { URI uri=file.toURI();
                URL url=uri.toURL();
                clip= Applet.newAudioClip(url);
            }
            catch(Exception ee) {
                ee.printStackTrace();
            }
        }
    }
