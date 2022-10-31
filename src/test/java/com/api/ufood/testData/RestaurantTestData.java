package com.api.ufood.testData;

import com.api.ufood.model.restaurant.*;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTestData {

    private Restaurant restaurant;


    // Constructor
    public RestaurantTestData() {

        // Set restaurant data
        setRestaurantData(
                getCategoryData(),
                getLocationData(),
                getPhotosData(),
                getHoursData(),
                getTransactionsData(),
                getCoordinatesData(),
                getReviewsData()
        );
    }


    private void setRestaurantData(
            List<Category> categories,
            Location location,
            List<String> photos,
            List<Hour> hours,
            List<String> transactions,
            Coordinates coordinates,
            Reviews reviews
    ) {
        restaurant = new Restaurant(
                "O4MKx3JGik8JgsjFinvp8w",
                "Pizza Deli & Company",
                "https://www.yelp.com/biz/pizza-deli-and-company-miami?adjust_creative=WhisvRGG7cdmmi1g3ljsIg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=WhisvRGG7cdmmi1g3ljsIg",
                "(786) 717-5848",
                categories,
                location,
                photos,
                "$$",
                hours,
                transactions,
                null,
                false,
                coordinates,
                187,
                4.0,
                reviews
        );
    }

    public Restaurant getRestaurant() { return restaurant; }

    private List<Category> getCategoryData() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Pizza"));
        categories.add(new Category("Pasta Shops"));
        categories.add(new Category("Salad"));

        return categories;
    }

    private Location getLocationData() {
        Location location = new Location();

        location.setAddress1("1920 SW 57th Ave");
        location.setAddress2("");
        location.setAddress3("");
        location.setCity("Miami");
        location.setZipCode("33155");
        location.setCountry("US");
        location.setState("FL");

        return location;
    }

    private List<String> getPhotosData() {
        List<String> photos = new ArrayList<>();

        photos.add("https://s3-media4.fl.yelpcdn.com/bphoto/B2d9na3Ad4YM7riIt1IUlw/o.jpg");
        photos.add("https://s3-media2.fl.yelpcdn.com/bphoto/N5x_j9Cqy5-cRfvKDJM65A/o.jpg");
        photos.add("https://s3-media4.fl.yelpcdn.com/bphoto/x3ffC1mqwyopmsTAloEyKg/o.jpg");

        return photos;
    }

    private List<Hour> getHoursData() {
        List<Hour> hours = new ArrayList<>();

        List<Open> open = new ArrayList<>();
        open.add(new Open(false, "1100", "2030", 0));
        open.add(new Open(false, "1100", "2030", 1));
        open.add(new Open(false, "1100", "2030", 2));
        open.add(new Open(false, "1100", "2030", 3));
        open.add(new Open(false, "1100", "2030", 4));
        open.add(new Open(false, "1100", "2030", 5));
        open.add(new Open(false, "1100", "2030", 6));


        hours.add(new Hour(open, "REGULAR", true));

        return hours;
    }

    private List<String> getTransactionsData() {
        List<String> transactions = new ArrayList<>();

        transactions.add("pickup");
        transactions.add("delivery");

        return transactions;
    }

    private Coordinates getCoordinatesData() {
        Coordinates coordinates = new Coordinates();

        coordinates.setLatitude(25.75271);
        coordinates.setLongitude(-80.28768);

        return coordinates;
    }

    private Reviews getReviewsData() {
        Reviews reviews = new Reviews();

        List<Review> review = new ArrayList<>();
        review.add(new Review(
                "0JLAK6F695HMCxqxTyW5tg",
                5,
                new User("qkz5YEJpNtu2-aZQntx38A", "Carol R."),
                "The pizza is always perfect.  \nTruth their meatballs are the best ever. \nAny time  I call to order always pleasant.",
                "2022-09-20 11:23:38"));

        review.add(new Review(
                "zEh4JBMLRzzw2QQkYE_bfw",
                5,
                new User("mpjn9btwdcSvJWORglGyJw", "Jessica R."),
                "Delicious and fresh pizza! They are huge and super loaded. We got the supreme and wow! I was blown away! Recommended 100%. It's a little whole in the wall...",
                "2022-10-12 18:18:06"));

        review.add(new Review(
                "TAzL5o_X3NAgbSH4yVOEtA",
                2,
                new User("GUvCdue7FPnfHuBo67WWmw", "Erbira B."),
                "This little place is just outside the Gables and I had heard it was good so we thought we'd give it a try. Firstly we were a little surprised that an 18\"...",
                "2022-03-30 17:47:23"));

        reviews.setReviewList(review);
        reviews.setTotal(187);

        return reviews;
    }
}
