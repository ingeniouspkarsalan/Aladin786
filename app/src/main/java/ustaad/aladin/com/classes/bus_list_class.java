package ustaad.aladin.com.classes;

import android.os.Parcel;
import android.os.Parcelable;

public class bus_list_class implements Parcelable{
    private  String b_id;
    private String b_name;
    private String b_email;
    private String b_image;
    private String b_mobile;
    private String b_city;
    private String b_address;
    private String b_detail;
    private Double b_lat;
    private Double b_long;


    public bus_list_class(String b_id, String b_name, String b_image, String b_mobile, String b_city,String b_address,String b_detail, Double b_lat, Double b_long,String b_email) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.b_image = b_image;
        this.b_mobile = b_mobile;
        this.b_city = b_city;
        this.b_address = b_address;
        this.b_detail = b_detail;
        this.b_lat = b_lat;
        this.b_long = b_long;
        this.b_email=b_email;
    }


    protected bus_list_class(Parcel in) {
        b_id = in.readString();
        b_name = in.readString();
        b_image = in.readString();
        b_mobile = in.readString();
        b_city = in.readString();
        b_address = in.readString();
        b_detail = in.readString();
        b_lat = in.readDouble();
        b_long = in.readDouble();
        b_email=in.readString();
    }

    public static final Creator<bus_list_class> CREATOR = new Creator<bus_list_class>() {
        @Override
        public bus_list_class createFromParcel(Parcel in) {
            return new bus_list_class(in);
        }

        @Override
        public bus_list_class[] newArray(int size) {
            return new bus_list_class[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(b_id);
        dest.writeString(b_name);
        dest.writeString(b_image);
        dest.writeString(b_mobile);
        dest.writeString(b_city);
        dest.writeString(b_address);
        dest.writeString(b_detail);
        dest.writeDouble(b_lat);
        dest.writeDouble(b_long);
        dest.writeString(b_email);
    }

    public String getB_id() {
        return b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public String getB_image() {
        return b_image;
    }

    public String getB_mobile() {
        return b_mobile;
    }

    public String getB_city() {
        return b_city;
    }

    public Double getB_lat() {
        return b_lat;
    }

    public Double getB_long() {
        return b_long;
    }

    public String getB_email() {
        return b_email;
    }

    public String getB_address() {
        return b_address;
    }

    public String getB_detail() {
        return b_detail;
    }
}
