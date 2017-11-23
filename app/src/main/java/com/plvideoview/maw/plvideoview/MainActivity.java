package com.plvideoview.maw.plvideoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoTextureView;
import com.pili.pldroid.player.widget.PLVideoView;
import com.plvideoview.maw.plvideoview.widget.MediaController;

public class MainActivity extends AppCompatActivity implements PLMediaPlayer.OnPreparedListener, PLMediaPlayer.OnInfoListener,
        PLMediaPlayer.OnCompletionListener, PLMediaPlayer.OnVideoSizeChangedListener, PLMediaPlayer.OnErrorListener{

    private PLVideoTextureView plVideoTextureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        plVideoTextureView=(PLVideoTextureView)findViewById(R.id.PLVideoTextureView);

        plVideoTextureView.setMediaController(new MediaController(this));
        //设置动画的入口
        /*plVideoTextureView.setBufferingIndicator();*/
        plVideoTextureView.setDisplayAspectRatio(PLVideoView.ASPECT_RATIO_FIT_PARENT);
        plVideoTextureView.setVideoPath("http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4");
    }

    @Override
    public void onCompletion(PLMediaPlayer plMediaPlayer) {

    }

    @Override
    public boolean onError(PLMediaPlayer plMediaPlayer, int i) {
        return false;
    }

    @Override
    public boolean onInfo(PLMediaPlayer plMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(PLMediaPlayer plMediaPlayer, int i) {
        plVideoTextureView.start();
    }

    @Override
    public void onVideoSizeChanged(PLMediaPlayer plMediaPlayer, int i, int i1) {

    }
}
