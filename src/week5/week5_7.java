package week5;

class MyTv{
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int previous_channel;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public boolean isPowerOn(){
        return isPowerOn;
    }
    public void gotoPrevChannel(){
        setChannel(previous_channel);
    }
    public void setChannel(int channel){
        if(channel < MIN_CHANNEL || channel > MAX_CHANNEL) return;
        this.previous_channel = this.channel;
        this.channel = channel;
    }
    public int getChannel(){
        return channel;
    }
    public void setVolume(int volume){
        if(volume < MIN_VOLUME || volume > MAX_VOLUME) return;
        this.volume = volume;
    }
    public int getVolume(){
        return volume;
    }
}
public class week5_7 {
    public static void main(String[] args){
    MyTv t =new MyTv();
    t.setChannel(10);
    System.out.println("채널 : " + t.getChannel());
    t.setVolume(20);
    System.out.println("음량 : " + t.getVolume());
    t.setChannel(20);
    System.out.println("채널 : " + t.getChannel());
    t.gotoPrevChannel();
    System.out.println("채널 : " + t.getChannel());
    t.gotoPrevChannel();
    System.out.println("채널 : " + t.getChannel());
    }
}
