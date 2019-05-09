package com.hotel.constants;

public class RateConstants {
    public interface Weekend{
        public interface RegularCustomer{
            public Double LAKE_TARRIF = 90.0;
            public Double BRIDGE_TARRIF = 60.0;
            public Double RIDGE_TARRIF = 150.0;
        }
        public interface RewardsCustomer{
            public Double LAKE_TARRIF = 80.0;
            public Double BRIDGE_TARRIF = 50.0;
            public Double RIDGE_TARRIF = 40.0;
        }
    }
    public interface Weekdays{
        public interface RegularCustomer{
            public Double LAKE_TARRIF = 110.0;
            public Double BRIDGE_TARRIF = 160.0;
            public Double RIDGE_TARRIF = 220.0;
        }
        public interface RewardsCustomer{
            public Double LAKE_TARRIF = 80.0;
            public Double BRIDGE_TARRIF = 110.0;
            public Double RIDGE_TARRIF = 100.0;
        }
    }
}
