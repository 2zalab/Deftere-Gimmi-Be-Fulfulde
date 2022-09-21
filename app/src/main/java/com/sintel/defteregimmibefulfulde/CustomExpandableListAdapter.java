package com.sintel.defteregimmibefulfulde;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context  context;
    private List<String> expandableListTitle;
    private TreeMap<String,List<String>> expandableListDetail;
    TextView textView;

    public CustomExpandableListAdapter(Context context, List<String>expandableListTitle, TreeMap<String,List<String>>expandableListDetail){
        this.context=context;
        this.expandableListTitle=expandableListTitle;
        this.expandableListDetail=expandableListDetail;
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).get(expandedListPosition);
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public long getChildId(int ListPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String expandedListDetailText =(String) getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_group,null);
        }
        TextView expandabletextView = (TextView)convertView.findViewById(R.id.listTitle);
        expandabletextView.setText(expandedListDetailText);
        ImageView imageView = convertView.findViewById(R.id.imageIndicator);
        TextView textView = convertView.findViewById(R.id.listTitle);
        //int color = textView.get();
        TypedValue typedValue=new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.primaryTextColor,typedValue,true);
        @ColorInt int color = typedValue.data;

        if (isExpanded){
            imageView.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
           // imageView.setColorFilter(R.color.colorPrimary, PorterDuff.Mode.MULTIPLY);
            textView.setTextColor(this.context.getResources().getColor(R.color.colorExpendableGroup));
        }else {
            imageView.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
             textView.setTextColor(color);
            //textView.setTextColor(this.context.getResources().getColor(R.color.itemTextColor));
        }
        return convertView;
    }

    @Override
    public View getChildView(int ListPosition, final int expandedListPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       final String expandedListText = (String) getChild(ListPosition,expandedListPosition);
       if(convertView==null){
           LayoutInflater layoutInflater =(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView=layoutInflater.inflate(R.layout.list_item,null);
       }
        TextView expendedListTextView=(TextView) convertView.findViewById(R.id.expanded_list_item);
        expendedListTextView.setText(expandedListText);
         textView = (convertView).findViewById(R.id.numero);

         Afficher_NumeroCantique(ListPosition,expandedListPosition);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

    public boolean Afficher_NumeroCantique(int parent, int fils){
        if (parent==0){
            switch (fils){
                case 0:
                    textView.setText("103");
                    return true;
                case 1:
                    textView.setText("56");
                    return true;
                case 2:
                    textView.setText("41");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==1){
            switch (fils){
                case 0 :
                    textView.setText("22");
                    return true;
                case 1 :
                    textView.setText("5");
                    return true;
                case 2 :
                    textView.setText("70");
                    return true;
                case 3 :
                    textView.setText("11");
                    return true;
                case 4 :
                    textView.setText("98");
                    return true;
                case 5 :
                    textView.setText("96");
                    return true;
                case 6 :
                    textView.setText("19");
                    return true;
                case 7 :
                    textView.setText("87");
                    return true;
                case 8 :
                    textView.setText("12");
                    return true;
                case 9 :
                    textView.setText("86");
                    return true;
                case 10 :
                    textView.setText("84");
                    return true;
                case 11 :
                    textView.setText("43");
                    return true;
                case 12 :
                    textView.setText("93");
                    return true;
                case 13 :
                    textView.setText("50");
                    return true;
                case 14 :
                    textView.setText("28");
                    return true;
                case 15 :
                    textView.setText("53");
                    return true;
                case 16 :
                    textView.setText("24");
                    return true;
                case 17 :
                    textView.setText("34");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==2){
            switch (fils) {
                case 0:
                    textView.setText("88");
                    return true;
                case 1:
                    textView.setText("55");
                    return true;
                case 2:
                    textView.setText("106");
                    return true;
                case 3:
                    textView.setText("2");
                    return true;
                case 4:
                    textView.setText("18");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==3){
            switch (fils) {
                case 0:
                    textView.setText("94");
                    return true;
                case 1:
                    textView.setText("77");
                    return true;
                case 2:
                    textView.setText("48");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==4){
            switch (fils) {
                case 0:
                    textView.setText("25");
                    return true;
                case 1:
                    textView.setText("17");
                    return true;
                case 2:
                    textView.setText("57");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==5){
            switch (fils) {
                case 0:
                    textView.setText("78");
                    return true;
                case 1:
                    textView.setText("33");
                    return true;
                case 2:
                    textView.setText("44");
                    return true;
                case 3:
                    textView.setText("66");
                    return true;
                case 4:
                    textView.setText("42");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==6){
            switch (fils) {
                case 0:
                    textView.setText("3");
                    return true;
                case 1:
                    textView.setText("54");
                    return true;
                case 2:
                    textView.setText("30");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==7){
            if (fils == 0) {
                textView.setText("64");
            }
        }
        else if (parent==8){
            switch (fils) {
                case 0:
                    textView.setText("20");
                    return true;
                case 1:
                    textView.setText("74");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==9){
            switch (fils) {
                case 0:
                    textView.setText("81");
                    return true;
                case 1:
                    textView.setText("97");
                    return true;
                case 2:
                    textView.setText("6");
                    return true;
                case 3:
                    textView.setText("80");
                    return true;
                case 4:
                    textView.setText("91");
                    return true;
                case 5:
                    textView.setText("90");
                    return true;
                case 6:
                    textView.setText("99");
                    return true;
                case 7:
                    textView.setText("73");
                    return true;
                case 8:
                    textView.setText("62");
                    return true;
                case 9:
                    textView.setText("14");
                    return true;
                case 10:
                    textView.setText("61");
                    return true;
                case 11:
                    textView.setText("27");
                    return true;
                case 12:
                    textView.setText("95");
                    return true;
                case 13:
                    textView.setText("40");
                    return true;
                case 14:
                    textView.setText("63");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==10){
            switch (fils) {
                case 0:
                    textView.setText("10");
                    return true;
                case 1:
                    textView.setText("104");
                    return true;
                case 2:
                    textView.setText("107");
                    return true;
                case 3:
                    textView.setText("47");
                    return true;
                case 4:
                    textView.setText("75");
                    return true;
                case 5:
                    textView.setText("85");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==11){
            if (fils==0){
                textView.setText("49");
            }

        }
        else if (parent==12){
            switch (fils) {
                case 0:
                    textView.setText("79");
                    return true;
                case 1:
                    textView.setText("83");
                    return true;
                case 2:
                    textView.setText("71");
                    return true;
                case 3:
                    textView.setText("4");
                    return true;
                case 4:
                    textView.setText("16");
                    return true;
                case 5:
                    textView.setText("67");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==13){
            switch (fils) {
                case 0:
                    textView.setText("31");
                    return true;
                case 1:
                    textView.setText("36");
                    return true;
                case 2:
                    textView.setText("100");
                    return true;
                case 3:
                    textView.setText("39");
                    return true;
                case 4:
                    textView.setText("105");
                    return true;
                case 5:
                    textView.setText("102");
                    return true;
                case 6:
                    textView.setText("59");
                    return true;
                case 7:
                    textView.setText("69");
                    return true;
                case 8:
                    textView.setText("58");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==14){
            if (fils==0){
                textView.setText("37");
            }
        }
        else if (parent==15){
            switch (fils) {
                case 0:
                    textView.setText("13");
                    return true;
                case 1:
                    textView.setText("76");
                    return true;
                case 2:
                    textView.setText("21");
                    return true;
                case 3:
                    textView.setText("101");
                    return true;
                case 4:
                    textView.setText("51");
                    return true;
                case 5:
                    textView.setText("68");
                    return true;
                case 6:
                    textView.setText("23");
                    return true;
                case 7:
                    textView.setText("8");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==16){
            switch (fils) {
                case 0:
                    textView.setText("72");
                    return true;
                case 1:
                    textView.setText("89");
                    return true;
                case 2:
                    textView.setText("32");
                    return true;
                case 3:
                    textView.setText("45");
                    return true;
                case 4:
                    textView.setText("38");
                    return true;
                case 5:
                    textView.setText("65");
                    return true;
                case 6:
                    textView.setText("26");
                    return true;
                case 7:
                    textView.setText("35");
                    return true;
                case 8:
                    textView.setText("15");
                    return true;
                case 9:
                    textView.setText("9");
                    return true;
                case 10:
                    textView.setText("29");
                    return true;
                case 11:
                    textView.setText("60");
                    return true;
                case 12:
                    textView.setText("7");
                    return true;
                case 13:
                    textView.setText("1");
                    return true;
                case 14:
                    textView.setText("46");
                    return true;
                case 15:
                    textView.setText("92");
                    return true;
                default:
                    return true;
            }
        }
        else if (parent==17){
            switch (fils){
                case 0:
                    textView.setText("52");
                    return true;
                case 1:
                    textView.setText("82");
                    return true;
                default:
                    return true;
            }
        }
        return false;
    }
}
