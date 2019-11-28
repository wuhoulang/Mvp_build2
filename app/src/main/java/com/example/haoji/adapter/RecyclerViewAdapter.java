package com.example.haoji.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.haoji.Activity.SpeakActivity;
import com.example.haoji.Bean.DataBean;
import com.example.haoji.Bean.GoodsBean;
import com.example.haoji.Service.MusicServices;
import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private DataBean.LineNineBean.ContentBeanXXXXXXXX biaoBean9;
    private DataBean.LineTenBean.ContentBeanXXXXXXXXX biaoBean10;
    private DataBean.LineElevenBean.ContentBeanXXXXXXXXXX biaoBean11;
    private DataBean.LineTwelveBean.ContentBeanXXXXXXXXXXX biaoBean12;
    private DataBean.LineThirteenBean.ContentBeanXXXXXXXXXXXX biaoBean13;
    private DataBean.LineFourteenBean.ContentBeanXXXXXXXXXXXXX biaoBean14;
    //extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder
    public Context mContext;
    public MusicServices service;
    private static final int EEGLISHSPEAK = 0;

    private static final int EEGLISHIMAGE = 1;

    private static final int EEGLISHBIAO = 2;

    private static final int EEGLISHIMAGE_TWO = 3;

    private static final int EEGLISHBIAO_TWO = 4;

    private static final int EEGLISHIMAGE_THREE = 5;

    private static final int EEGLISHBIAO_THREE = 6;

    private static final int EEGLISHIMAGE_FOUR = 7;

    private static final int EEGLISHBIAO_FOUT = 8;

    private static final int EEGLISHIMAGE_FIVE = 9;

    private static final int EEGLISHBIAO_FIVE = 10;

    private static final int EEGLISHIMAGE_SIX = 11;

    private static final int EEGLISHBIAO_SIX = 12;

    private static final int EEGLISHIMAGE_SEVEN = 13;

    private int currentType = EEGLISHSPEAK;
    //    private BiaoBean.ContentBean biaoBean;
    private DataBean.LineOneBean.ContentBean biaoBean;
    private DataBean.LineTwoBean.ContentBeanX biaoBean2;
    private DataBean.LineThreeBean.ContentBeanXX biaoBean3;
    private DataBean.LineFourBean.ContentBeanXXX biaoBean4;
    private DataBean.LineFiveBean.ContentBeanXXXX biaoBean5;
    private DataBean.LineSixBean.ContentBeanXXXXX biaoBean6;
    private DataBean.LineSevenBean.ContentBeanXXXXXX biaoBean7;
    private DataBean.LineEightBean.ContentBeanXXXXXXX biaoBean8;


    public RecyclerViewAdapter(Context context, DataBean.LineOneBean.ContentBean biaoBean, DataBean.LineTwoBean.ContentBeanX biaoBean2,
                               DataBean.LineThreeBean.ContentBeanXX biaoBean3, DataBean.LineFourBean.ContentBeanXXX biaoBean4, DataBean.LineFiveBean.ContentBeanXXXX biaoBean5,
                               DataBean.LineSixBean.ContentBeanXXXXX biaoBean6, DataBean.LineSevenBean.ContentBeanXXXXXX biaoBean7
            , DataBean.LineEightBean.ContentBeanXXXXXXX biaoBean8,DataBean.LineNineBean.ContentBeanXXXXXXXX biaoBean9,
                               DataBean.LineTenBean.ContentBeanXXXXXXXXX biaoBean10,DataBean.LineElevenBean.ContentBeanXXXXXXXXXX biaoBean11,
                               DataBean.LineTwelveBean.ContentBeanXXXXXXXXXXX biaoBean12,DataBean.LineThirteenBean.ContentBeanXXXXXXXXXXXX biaoBean13,DataBean.LineFourteenBean.ContentBeanXXXXXXXXXXXXX biaoBean14) {
        this.mContext = context;
        this.biaoBean = biaoBean;
        this.biaoBean2 = biaoBean2;
        this.biaoBean3 = biaoBean3;
        this.biaoBean4 = biaoBean4;
        this.biaoBean5 = biaoBean5;
        this.biaoBean6 = biaoBean6;
        this.biaoBean7 = biaoBean7;
        this.biaoBean8 = biaoBean8;
        this.biaoBean9 = biaoBean9;
        this.biaoBean10 = biaoBean10;
        this.biaoBean11 = biaoBean11;
        this.biaoBean12 = biaoBean12;
        this.biaoBean13 = biaoBean13;
        this.biaoBean14 = biaoBean14;
        Log.e("pos", "biaoBean12:" + biaoBean14.getPage_data().get(0).getChinesename());

        Log.e("onItemClick", "--RecyclerViewAdapter:");
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        GridView id_gv;
        GridView id_gv2;

        public ViewHolder(View view) {
            super(view);
            id_gv = view.findViewById(R.id.id_gv);
            id_gv2 = view.findViewById(R.id.id_gv2);
//            id_iv10 = view.findViewById(R.id.id_iv10);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == EEGLISHSPEAK) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_image, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_TWO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_TWO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_THREE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_THREE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_FOUR) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_FOUT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_FIVE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_FIVE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_SIX) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_SIX) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_SEVEN) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case EEGLISHSPEAK:
                currentType = EEGLISHSPEAK;
                break;
            case EEGLISHIMAGE:
                currentType = EEGLISHIMAGE;
                break;
            case EEGLISHBIAO:
                currentType = EEGLISHBIAO;
                break;
            case EEGLISHIMAGE_TWO:
                currentType = EEGLISHIMAGE_TWO;
                break;
            case EEGLISHBIAO_TWO:
                currentType = EEGLISHBIAO_TWO;
                break;
            case EEGLISHIMAGE_THREE:
                currentType = EEGLISHIMAGE_THREE;
                break;
            case EEGLISHBIAO_THREE:
                currentType = EEGLISHBIAO_THREE;
                break;
            case EEGLISHIMAGE_FOUR:
                currentType = EEGLISHIMAGE_FOUR;
                break;
            case EEGLISHBIAO_FOUT:
                currentType = EEGLISHBIAO_FOUT;
                break;
            case EEGLISHIMAGE_FIVE:
                currentType = EEGLISHIMAGE_FIVE;
                break;
            case EEGLISHBIAO_FIVE:
                currentType = EEGLISHBIAO_FIVE;
                break;
            case EEGLISHIMAGE_SIX:
                currentType = EEGLISHIMAGE_SIX;
                break;
            case EEGLISHBIAO_SIX:
                currentType = EEGLISHBIAO_SIX;
                break;
            case EEGLISHIMAGE_SEVEN:
                currentType = EEGLISHIMAGE_SEVEN;
                break;
        }
        return currentType;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        if (position==0||position == 3 || position == 5 || position == 7 || position == 9 || position == 11 || position == 13) {
            GridViewAdapter ga = new GridViewAdapter(mContext, position);
            holder.id_gv.setAdapter(ga);
            GridViewAdapter2 ga2 = new GridViewAdapter2(mContext, position);
            holder.id_gv2.setAdapter(ga2);
            setItemData(holder, position);
        }


    }

    private void setItemData(@NonNull ViewHolder holder, final int pos) {
        holder.id_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                GoodsBean goodsBean = null;
                Intent intent = new Intent(mContext, SpeakActivity.class);
                if (pos == 0) {
                    goodsBean = new GoodsBean(biaoBean.getPage_data().get(position).getChinesename(), biaoBean.getPage_data().get(position).getEnglishname(), biaoBean.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                } else if (pos == 3) {
                    goodsBean = new GoodsBean(biaoBean3.getPage_data().get(position).getChinesename(), biaoBean3.getPage_data().get(position).getEnglishname(), biaoBean3.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                } else if (pos == 5) {
                    goodsBean = new GoodsBean(biaoBean5.getPage_data().get(position).getChinesename(), biaoBean5.getPage_data().get(position).getEnglishname(), biaoBean5.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }else if (pos == 7) {
                    goodsBean = new GoodsBean(biaoBean7.getPage_data().get(position).getChinesename(), biaoBean7.getPage_data().get(position).getEnglishname(), biaoBean7.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }else if (pos == 9) {
                    goodsBean = new GoodsBean(biaoBean9.getPage_data().get(position).getChinesename(), biaoBean9.getPage_data().get(position).getEnglishname(), biaoBean9.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }else if (pos == 11) {
                    goodsBean = new GoodsBean(biaoBean11.getPage_data().get(position).getChinesename(), biaoBean11.getPage_data().get(position).getEnglishname(), biaoBean11.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }else if (pos == 13) {
                    goodsBean = new GoodsBean(biaoBean13.getPage_data().get(position).getChinesename(), biaoBean13.getPage_data().get(position).getEnglishname(), biaoBean13.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }
                intent.putExtra("name", goodsBean);
                intent.putExtra("position", pos);
                mContext.startActivity(intent);
                Log.e("onItemClick", "--int:" + position);
            }
        });

        holder.id_gv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                GoodsBean goodsBean = null;
                Intent intent = new Intent(mContext, SpeakActivity.class);
                if (pos == 0) {
                    goodsBean = new GoodsBean(biaoBean2.getPage_data().get(position).getChinesename(), biaoBean2.getPage_data().get(position).getEnglishname(), biaoBean2.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                } else if (pos == 3) {
                    goodsBean = new GoodsBean(biaoBean4.getPage_data().get(position).getChinesename(), biaoBean4.getPage_data().get(position).getEnglishname(), biaoBean4.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                } else if (pos == 5) {
                    goodsBean = new GoodsBean(biaoBean6.getPage_data().get(position).getChinesename(), biaoBean6.getPage_data().get(position).getEnglishname(), biaoBean6.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }else if (pos == 7) {
                    goodsBean = new GoodsBean(biaoBean8.getPage_data().get(position).getChinesename(), biaoBean8.getPage_data().get(position).getEnglishname(), biaoBean8.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }else if (pos == 9) {
                    goodsBean = new GoodsBean(biaoBean10.getPage_data().get(position).getChinesename(), biaoBean10.getPage_data().get(position).getEnglishname(), biaoBean10.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }else if (pos == 11) {
                    goodsBean = new GoodsBean(biaoBean12.getPage_data().get(position).getChinesename(), biaoBean11.getPage_data().get(position).getEnglishname(), biaoBean11.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }else if (pos == 13) {
                    goodsBean = new GoodsBean(biaoBean14.getPage_data().get(position).getChinesename(), biaoBean13.getPage_data().get(position).getEnglishname(), biaoBean13.getPage_data().get(position).getPicture(),biaoBean.getPage_data().get(position).getMusic());
                }
                intent.putExtra("name", goodsBean);
                intent.putExtra("position", pos);
                mContext.startActivity(intent);
                Log.e("onItemClick", "--int:" + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 14;
    }


}
