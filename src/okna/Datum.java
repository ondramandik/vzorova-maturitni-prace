package okna;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datum {

    private Date mDate;

    public Datum(Date date) {
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(mDate);
    }
}
