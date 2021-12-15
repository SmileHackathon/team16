package jp.ac.`fun`.hackathon.santaclaushasfallen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent//画面遷移に必要なインポート
import android.view.View//画面遷移に必要なインポート
import android.media.MediaPlayer//MediaPlayerをつかえるようにする

class MainActivity : AppCompatActivity() {
    lateinit var mp1:MediaPlayer//MediaPlayerの使用を定義する
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp1= MediaPlayer.create(this,R.raw.title)//titleというBGMを読み込む
        mp1.isLooping=true//BGMをループする
        mp1.start()//BGMをスタートする
    }
    // 実行ボタンタップ時
    fun onButtonTapped(view: View?){
        val intent = Intent(this, SubActivity::class.java)//SubActivityにとぶ
        startActivity(intent)
        mp1.release()//BGMを終了する
    }

}

