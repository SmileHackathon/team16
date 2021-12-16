package jp.ac.`fun`.hackathon.santaclaushasfallen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent//画面遷移に必要なインポート
import android.view.View//画面遷移に必要なインポート
import android.media.MediaPlayer//MediaPlayerをつかえるようにする
class mistake : AppCompatActivity() {

    lateinit var mp0:MediaPlayer//MediaPlayerの使用を定義する
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mistake)

        mp0= MediaPlayer.create(this,R.raw.badend)//badendというBGMを読み込む
        mp0.isLooping=true//BGMをループする
        mp0.start()//BGMをスタートする

    }




    // 実行ボタンタップ時
    fun onButtonTapped(view: View?){
        val intent = Intent(this, MainActivity::class.java)//MainActivityにとぶ
        startActivity(intent)
        mp0.release()//BGMを終了する
    }
}
//rawというBGMファイルを作りました。