//package jp.ac.`fun`.hackathon.santaclaushasfallen
//
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View//画面遷移に必要なインポート
//import android.content.Intent//画面遷移に必要なインポート
//import android.media.MediaPlayer//MediaPlayerをつかえるようにする
//import android.os.Handler
//import android.util.Log
//import kotlinx.android.synthetic.main.activity_sub.*
//import android.widget.ImageView
//
//class SubActivity : AppCompatActivity() {
//    lateinit var mp1:MediaPlayer//MediaPlayerの使用を定義する
//    val boy: ImageView = fiindViewById(R.id.sleep_boy)//変数boyにboy_sleepingのidを代入
//
//    private fun fiindViewById(sleepBoy: Int): ImageView {
//        TODO("Not yet implemented")
//    }
//
//    private var M=100
//   // private var u=0
//    private var sleep=0
//    private var count=0
//
//    var cnt=0
//    val hnd0=Handler()
//    val rnb0=object : Runnable{
//        override fun run() {
//            cnt++
//            t0.text=cnt.toString()
//            if(cnt<50){
//                hnd0.postDelayed(this,1000)
//            }
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sub)
//
//        mp1= MediaPlayer.create(this,R.raw.gameing)//gameingというBGMを読み込む
//        mp1.isLooping=true//BGMをループする
//        mp1.start()//BGMをスタートする
//        hnd0.post(rnb0)
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
//            Log.d("SubActivity","hello")
//            M -= 1//距離が
//            if(sleep==1){
//                boy.setImageResource(R.drawable.neboke_boy)//子どもが起きそうな画像に切り替え
//                count+=1
//            }
//            if(sleep==0){
//                boy.setImageResource(R.drawable.sleep)//子どもが寝ている画像に切り替え
//                count=0
//            }
//            if(cnt==50){
//                boy.setImageResource(R.drawable.getup_boy)//子どもが起きた画像に切り替え
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


//package jp.ac.`fun`.hackathon.santaclaushasfallen
//
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View//画面遷移に必要なインポート
//import android.content.Intent//画面遷移に必要なインポート
//import android.media.MediaPlayer//MediaPlayerをつかえるようにする
//
//class SubActivity : AppCompatActivity() {
//    lateinit var mp1:MediaPlayer//MediaPlayerの使用を定義する
//    private var M=100
//    private var u=0
//    private var sleep=0
//    private var count=0
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sub)
//
//        mp1= MediaPlayer.create(this,R.raw.gameing)//gameingというBGMを読み込む
//        mp1.isLooping=true//BGMをループする
//        mp1.start()//BGMをスタートする
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



package jp.ac.`fun`.hackathon.santaclaushasfallen


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View//画面遷移に必要なインポート
import android.content.Intent//画面遷移に必要なインポート
import android.media.MediaPlayer//MediaPlayerをつかえるようにする
import android.os.Handler
import android.animation.ObjectAnimator//アニメーションのライブラリ
import android.util.Log
import kotlinx.android.synthetic.main.activity_sub.*
import android.widget.ImageView
import android.widget.TextView

class SubActivity : AppCompatActivity(), Runnable {
    lateinit var mp1:MediaPlayer//MediaPlayerの使用を定義する
    var boy: ImageView? = null
        private fun fiindViewById(sleepBoy: Int): ImageView {
            TODO("Not yet implemented")
        }
    private var M=100
    private var u=0
    private var count=0
    var cnt=0
    private var santa: ImageView? = null //サンタの画像
    private var distance: TextView? = null //距離の表示
    private var text: String? = null //変換のための変数。

    val hnd0=Handler()
    val rnb0=object : Runnable{
        override fun run() {
            cnt++
            //t0.text=cnt.toString()
            if(cnt<100){
                hnd0.postDelayed(this,1000)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        boy=findViewById(R.id.sleep_boy)
        santa = findViewById(R.id.santa) //サンタ画像の代入
        distance = findViewById(R.id.Distance) //距離のテキストの代入
        mp1= MediaPlayer.create(this,R.raw.gameing)//gameingというBGMを読み込む
        mp1.isLooping=true//BGMをループする
        mp1.start()//BGMをスタートする
        hnd0.post(rnb0)


    }




    //ボタンを押したとき
    fun onButtonTapped(view: View?) {


        if (M >= 1) {
            Log.d("SubActivity","hello")
            M -= 1//距離が
            u+=1
            val move: View = findViewById(R.id.santa)
            ObjectAnimator.ofFloat(move, "translationX", u*5f, u*5+5f).apply{
                //サンタの画像のx座標を変える
                //引数はそれぞれサンタの画像のImageView、プロパティ名、
                duration = 1//移動にかかる時間
                start()
            }
            ObjectAnimator.ofFloat(move, "translationY", u*8f, u*8+8f).apply {//サンタの画像のy座標を変える
                duration = 1
                start()
            }
            text = M.toString()//文字列データに変換し
            distance?.text = text //テキストに反映
            if(cnt%4==0){


                boy?.setImageResource(R.drawable.sleep)//子どもが眠っている画像に切り替え
                count=0

            }
            if (cnt%4==1){
                count=0
                boy?.setImageResource(R.drawable.sleep)//子どもが起きた画像に切り替え
            }
            if (cnt%4==2){
                count+=1
                boy?.setImageResource(R.drawable.neboke_boy)//子どもが起きそう画像に切り替え
            }
            if (cnt%4==3){
                count+=1
                boy?.setImageResource(R.drawable.neboke_boy)//子どもが起きそう画像に切り替え
            }

            if(count==7){
                boy?.setImageResource(R.drawable.getup_boy)//子どもが起きた画像に切り替え
                //hnd0.postDelayed(this,1000)
                val intent = Intent(this, mistake::class.java)//距離が０になったらmistakeにとぶ
                mp1.release()//BGMを終了する
                startActivity(intent)
            }
        }
        if(M==0){
            val intent = Intent(this, clear::class.java)//距離が０になったらclearにとぶ
            startActivity(intent)
            mp1.release()//BGMを終了する
        }
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}



//package jp.ac.`fun`.hackathon.santaclaushasfallen
//
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View//画面遷移に必要なインポート
//import android.content.Intent//画面遷移に必要なインポート
//import android.media.MediaPlayer//MediaPlayerをつかえるようにする
//import android.os.Handler
//import android.animation.ObjectAnimator//アニメーションのライブラリ
//import android.util.Log
//import kotlinx.android.synthetic.main.activity_sub.*
//import android.widget.ImageView
//import android.widget.TextView
//
//class SubActivity : AppCompatActivity(), Runnable {
//    lateinit var mp1:MediaPlayer//MediaPlayerの使用を定義する
//    var boy: ImageView? = null
//    private fun fiindViewById(sleepBoy: Int): ImageView {
//        TODO("Not yet implemented")
//    }
//    private var M=10
//    private var u=0
//    private var count=0
//    var cnt=0
//    private var waru=0
//    private var santa: ImageView? = null //サンタの画像
//    private var distance: TextView? = null //距離の表示
//    private var text: String? = null //変換のための変数。
//
//    val hnd0=Handler()
//    val rnb0=object : Runnable{
//        override fun run() {
//            cnt++
//            t0.text=cnt.toString()
//            if(cnt<100){
//                hnd0.postDelayed(this,1000)
//            }
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sub)
//        boy=findViewById(R.id.sleep_boy)
//        mp1= MediaPlayer.create(this,R.raw.gameing)//gameingというBGMを読み込む
//        mp1.isLooping=true//BGMをループする
//        mp1.start()//BGMをスタートする
//        hnd0.post(rnb0)
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
//            Log.d("SubActivity","hello")
//            M -= 1//距離が
//            u+=1
//            if(cnt%4==0){
//
//
//                boy?.setImageResource(R.drawable.sleep)//子どもが眠っている画像に切り替え
//                count=0
//            }
//            if (cnt%4==1){
//                count=0
//                boy?.setImageResource(R.drawable.sleep)//子どもが起きた画像に切り替え
//            }
//            if (cnt%4==2){
//                count+=1
//                boy?.setImageResource(R.drawable.neboke_boy)//子どもが起きそう画像に切り替え
//            }
//            if (cnt%4==3){
//                count+=1
//                boy?.setImageResource(R.drawable.neboke_boy)//子どもが起きそう画像に切り替え
//            }
//
//            if(count==7){
//                boy?.setImageResource(R.drawable.getup_boy)//子どもが起きた画像に切り替え
//                //hnd0.postDelayed(this,1000)
//                val intent = Intent(this, mistake::class.java)//距離が０になったらmistakeにとぶ
//                mp1.release()//BGMを終了する
//                startActivity(intent)
//            }
//        }
//        if(M==0){
//            val intent = Intent(this, clear::class.java)//距離が０になったらclearにとぶ
//            startActivity(intent)
//            mp1.release()//BGMを終了する
//        }
//    }
//
//    override fun run() {
//        TODO("Not yet implemented")
//    }
//}
