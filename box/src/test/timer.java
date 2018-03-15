package test;

import java.util.Timer;
import java.util.TimerTask;

public class timer
{
  Methods horst;
  Timer timer;
  Timer time;
  
  public timer(Methods heinz)
  {
    this.horst = heinz;
    this.time = new Timer();
  }
  
  public void startTimer()
  {
    this.timer = new Timer();
    this.timer.scheduleAtFixedRate(new TimerTask()
    {
      public void run()
      {
        // timer.this.doThis();
      }
    }, 0L, 1000L);
    
    Timer check = new Timer();
    check.schedule(new TimerTask()
    {
      public void run()
      {
       // timer.this.doThat();
      }
    }, 1000L);
  }
  /**
  protected void doThat()
  {
    if ((this.horst.player != null) && (this.horst.player.isPlaying())) {
      while (this.horst.player.isPlaying()) {
        if (this.horst.player.getTime().toMillis() <= this.horst.player.getCurrent().toMillis()) {
          this.horst.next();
        }
      }
    }
  }
  
  public void stopTimer()
  {
    this.timer.cancel();
    this.timer.purge();
    this.timer = null;
  }
  
  protected void doThis()
  {
    if ((this.horst.player != null) && (this.horst.player.isPlaying()))
    {
      int time = (int)Math.round(this.horst.player.getTime().toSeconds());
      int milliseconds = (int)Math.round(this.horst.player.getCurrent().toMillis());
      int seconds = milliseconds / 1000 % 60;
      int minutes = milliseconds / 60000 % 60;
      String sec;
      if (seconds < 10) {
        sec = "0" + seconds;
      } else {
        sec = "" + seconds;
      }
      String min;
      if (minutes < 10) {
        min = "0" + minutes;
      } else {
        min = "" + minutes;
      }
      int m = 0;int s = 0;
      while (time > 0) {
        if (time > 59)
        {
          m++;
          time -= 60;
        }
        else
        {
          s++;
          time--;
        }
      }
      String su;
      if (s < 10) {
        su = "0" + s;
      } else {
        su = "" + s;
      }
      String mu;
      if (m < 10) {
        mu = "0" + m;
      } else {
        mu = ""+m;
      }
      
      horst.gui.timeFrame.setText("[" + min + ":" + sec + "] - [" + mu + ":" + su + "]");
      this.horst.gui.timeSlider.setMax((int)Math.round(this.horst.player.getTime().toSeconds()));
      this.horst.gui.timeSlider.setValue((int)Math.round(this.horst.player.getCurrent().toSeconds()));

    }
  }
  */
}
