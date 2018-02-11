package com.example.izzyengelbert.noesantarakoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Information extends AppCompatActivity {

    int key;
    String[] information = new String[8];
    String[] title = new String[8];
    Map<Integer,Integer> src = new HashMap<Integer,Integer>();
    TextView titleTxt;
    TextView infoTxt;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        initVariables();
    }

    public void initVariables(){
        key = getIntent().getExtras().getInt("key");
        titleTxt = (TextView) findViewById(R.id.title);
        infoTxt = (TextView) findViewById(R.id.information);
        img = (ImageView) findViewById(R.id.image);
        information = new String[8];
        setInformation();
        setContent();
    }

    public void setContent(){
        titleTxt.setText(title[key]);
        infoTxt.setText(information[key]);
        img.setImageResource(src.get(key));
    }

    public void setInformation(){
        information[0]=getString(R.string.sumatera_info);
        information[1]=getString(R.string.kalimantan_info);
        information[2]="Jawa adalah sebuah pulau di Indonesia dan merupakan terluas ke-13 di dunia. Dengan jumlah penduduk sekitar hampir 160 juta, pulau ini berpenduduk terbanyak di dunia dan merupakan salah satu tempat terpadat di dunia. Meskipun hanya menempati urutan terluas ke-5, Pulau Jawa dihuni oleh 60% penduduk Indonesia, Angka ini turun jika di bandingkan sensus penduduk tahun 1905 yang mencapai 80,6% dari seluruh penduduk indonesia penurunan penduduk di pulau jawa secara persentase di akibatkan perpindahan penduduk(Transmigrasi) dari pulau jawa ke seluruh indonesia. Ibu kota Indonesia, Jakarta, terletak di Jawa bagian barat laut (tepatnya di ujung paling barat Jalur Pantura).\n" +
                "\n" +
                "Jawa adalah pulau yang relatif muda dan sebagian besar terbentuk dari aktivitas vulkanik. Deretan gunung-gunung berapi membentuk jajaran yang terbentang dari timur hingga barat pulau ini, dengan dataran endapan aluvial sungai di bagian utara.\n" +
                "\n" +
                "Banyak sejarah Indonesia berlangsung di pulau ini. Dahulu, Jawa adalah pusat beberapa kerajaan Hindu-Buddha, kesultanan Islam, pemerintahan kolonial Hindia-Belanda, serta pusat pergerakan kemerdekaan Indonesia. Pulau ini berdampak besar terhadap kehidupan sosial, politik, dan ekonomi Indonesia.\n" +
                "\n" +
                "Sebagian besar penduduknya bertutur dalam tiga bahasa utama. Bahasa Jawa merupakan bahasa ibu dari 100 juta penduduk Indonesia, dan sebagian besar penuturnya berdiam di pulau Jawa. Sebagian besar penduduk adalah bilingual, yang berbahasa Indonesia baik sebagai bahasa pertama maupun kedua. Dua bahasa penting lainnya adalah bahasa Sunda dan bahasa Betawi. Sebagian besar penduduk Pulau Jawa adalah muslim dan Kristen, namun terdapat beragam aliran kepercayaan, agama, kelompok etnis, serta budaya di pulau ini.\n" +
                "\n" +
                "Pulau ini secara administratif terbagi menjadi enam provinsi, yaitu Jawa Barat, Jawa Tengah, Jawa Timur, dan Banten; serta dua wilayah khusus, yaitu DKI Jakarta dan DI Yogyakarta.\n"
                + getString(R.string.jawa_info);
        information[3]=getString(R.string.bali_lombok_info);
        information[4]=getString(R.string.kepulauan_nusa_tenggara_info);
        information[5]=getString(R.string.sulawesi_info);
        information[6]=getString(R.string.kepulauan_maluku_info);
        information[7]=getString(R.string.irian_jaya_info);

        title[0]=getString(R.string.sumatera);
        title[1]=getString(R.string.kalimantan);
        title[2]=getString(R.string.jawa);
        title[3]=getString(R.string.bali_lombok);
        title[4]=getString(R.string.kepulauan_nusa_tenggara);
        title[5]=getString(R.string.sulawesi);
        title[6]=getString(R.string.kepulauan_maluku);
        title[7]=getString(R.string.irian_jaya);

        src.put(0,R.drawable.sumatera1);
        src.put(1,R.drawable.kalimantan1);
        src.put(2,R.drawable.jawa1);
        src.put(3,R.drawable.bali_lombok1);
        src.put(4,R.drawable.kepulauan_nusa_tenggara1);
        src.put(5,R.drawable.sulawesi1);
        src.put(6,R.drawable.kepulauan_maluku1);
        src.put(7,R.drawable.irian_jaya1);
    }
}
