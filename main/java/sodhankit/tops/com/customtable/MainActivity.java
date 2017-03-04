package sodhankit.tops.com.customtable;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TableLayout tableLayout;
    private Button button;
    String[] DATPost={"03-AUG-2014","03-AUG-2014","03-AUG-2014","03-AUG-2014"};
    String[] DatVal={"31-AUG-2014","31-AUG-2014","31-AUG-2014","31-AUG-2014"};
    String[] Narration={"Principle","Interest","Interest","Interest"};
    String[] Credit={"0.00","0.00","0.00","0.00"};
    String[] Debit={"30","22","23","152"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayout=(TableLayout)findViewById(R.id.drawer_layout);
        addHeaderRow();
        addRows();

    }

    private void addHeaderRow()
    {
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        TextView tvTxnDate = getTextView("TxnDate", -1,true,R.drawable.header_background);

        tr.addView(tvTxnDate);

        TextView tvDatVal = getTextView("DatVal", -1,true,R.drawable.header_background);
        tr.addView(tvDatVal);

        TextView tvNarration = getTextView("Narration", -1,true,R.drawable.header_background);
        tr.addView(tvNarration);

        TextView tvDebit = getTextView("DR.", -1,true,R.drawable.header_background);
        tr.addView(tvDebit);

        TextView tvCredit = getTextView("CR.", -1,true,R.drawable.header_background);
        tr.addView(tvCredit);

        tableLayout.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

    }

    private void addRows() {
        int count=200;
        for(int k=0;k<DATPost.length;k++) {

            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            TextView labelvalDate = getTextView(DATPost[k], count,false,R.drawable.cell_background);
            labelvalDate.setClickable(true);

            tr.addView(labelvalDate);

            TextView labelnarr = getTextView(DatVal[k], count,false,R.drawable.cell_background);
            tr.addView(labelnarr);

            TextView labeldr = getTextView(Narration[k], count,false,R.drawable.cell_background);
            tr.addView(labeldr);

            TextView labelcr = getTextView(Credit[k].trim(), count,false,R.drawable.cell_background);
            tr.addView(labelcr);

            TextView Runnbal = getTextView(Debit[k], count,false,R.drawable.cell_background);
            tr.addView(Runnbal);

            tableLayout.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }
    public TextView getTextView(String value, int count,boolean boldFlag,int background)
    {
        TextView textview = new TextView(this);
        textview.setLayoutParams(new TableRow.LayoutParams(
                0, TableRow.LayoutParams.WRAP_CONTENT,1.0f));
        textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        if(count!=-1)
            textview.setId(200 + count);
        textview.setText(value);
        textview.setTextColor(Color.BLACK);
        if(boldFlag)
            textview.setTypeface(Typeface.DEFAULT_BOLD);
        textview.setBackgroundResource(background);
        return textview;
    }
}
