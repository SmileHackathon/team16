package jp.ac.`fun`.hackathon.santaclaushasfallen

import android.content.Intent//画面遷移に必要なインポート
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View//画面遷移に必要なインポート
import android.media.MediaPlayer//MediaPlayerをつかえるようにする

class clear : AppCompatActivity() {
    lateinit var mp1:MediaPlayer//MediaPlayerの使用を定義する
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clear)

        mp1= MediaPlayer.create(this,R.raw.happyend)//happyendというBGMを読み込む
        mp1.isLooping=true//BGMをループする
        mp1.start()//BGMをスタートする
    }
    fun onButtonTapped(view: View?){
        val intent = Intent(this, MainActivity::class.java)//MainActivityにとぶ
        startActivity(intent)
        mp1.release()//BGMを終了する
    }
}