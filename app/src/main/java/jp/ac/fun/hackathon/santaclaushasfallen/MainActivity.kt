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
//package jp.ac.`fun`.hackathon.santaclaushasfallen
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View//画面遷移に必要なインポート
//import android.content.Intent//画面遷移に必要なインポート
//import android.media.MediaPlayer//MediaPlayerをつかえるようにする
//
//class MainActivity : AppCompatActivity() {
//    lateinit var mp1:MediaPlayer//MediaPlayerの使用を定義する
//    private var M=3
//    private var T=0
//    private var u=0
//    private var sleep=0
//    private var count=0
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sub)
//        if(T==0){
//            val intent = Intent(this, SubActivity::class.java)//距離が０になったらSubActivityにとぶ
//            startActivity(intent)
//            T+=1
//        }
//        mp1= MediaPlayer.create(this,R.raw.gameing)//gameingというBGMを読み込む
//        mp1.isLooping=true//BGMをループする
//        mp1.start()//BGMをスタートする
//
//
//
//    }
//
//
//
//
//    //ボタンを押したとき
//    fun onButtonTapped(view: View?) {
//
//
//        if (M >= 1) {
//            M -= 1//距離が
//            if(sleep==1){
//                count+=1
//            }
//            if(sleep==0){
//                count=0
//            }
//            if(count==1){
//                val intent = Intent(this, mistake::class.java)//距離が０になったらclearにとぶ
//                startActivity(intent)
//            }
//        }
//        if(M==0){
//            val intent = Intent(this, clear::class.java)//距離が０になったらclearにとぶ
//            startActivity(intent)
//            mp1.release()//BGMを終了する
//        }
//    }
//}

