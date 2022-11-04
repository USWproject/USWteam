package com.akj.helpyou.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akj.helpyou.R;
import com.akj.helpyou.activities.search.SearchActivity;

public class FindRoadActivity extends Activity {



    private Button btnrecent1;
    private Button btnrecent2;
    private Button btnrecent3;
    private Button btnfindroad;
    private int startrequestcode = 100;
    private int endrequestcode = 101;
    private TextView startText;
    private TextView endText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_to_findroad);

        startText = (TextView) findViewById(R.id.addressSearchEditText1);
        endText = (TextView) findViewById(R.id.addressSearchEditText2);
        startText.setInputType(0);
        endText.setInputType(0);


        startText.setOnClickListener( //출발지 EditText버튼 클릭시
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                        intent.putExtra("textView1","출발지");
                        startActivityForResult(intent, startrequestcode);
                    }
                }
        );
        endText.setOnClickListener( //도착지 EditText버튼 클릭시
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                        intent.putExtra("textView1","도착지");
                        startActivityForResult(intent, endrequestcode);
                    }
                }
        );

        btnrecent1 = (Button) findViewById(R.id.recent_area);
        btnrecent2 = (Button) findViewById(R.id.recent_route);
        btnrecent3 = (Button) findViewById(R.id.recent_bookmark);

//        btnrecent1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RecentAreaActivity.class);
//                startActivity(intent);
//            }
//        });
//        btnrecent2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RecentRouteActivity.class);
//                startActivity(intent);
//            }
//        });
//        btnrecent3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RecentBookmarkActivity.class);
//                startActivity(intent);
//            }
//        });


        // 길찾기 버튼을 누르면 경로를 탐색한다. -> 경로를 알려주는 layout + 대중교통 알림 layout추가
        btnfindroad = (Button) findViewById(R.id.findRoad);
        btnfindroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultRouteActivity.class);
                startActivity(intent);
            }
        });

        //MainActivity에서 마커로 눌러서 와졌을때
        if(getIntent().hasExtra("startPoint") && getIntent().hasExtra("endPoint")){
            startText.setText(getIntent().getStringExtra("startPoint"));
            endText.setText(getIntent().getStringExtra("endPoint"));

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==startrequestcode){
            if (resultCode != Activity.RESULT_OK) {
                return;
            }
            String sendText = data.getExtras().getString("returnValue");
            startText.setText(sendText);
        }else if(requestCode==endrequestcode){
            if (resultCode != Activity.RESULT_OK) {
                return;
            }
            String sendText = data.getExtras().getString("returnValue");
            endText.setText(sendText);
        }
    }
}
