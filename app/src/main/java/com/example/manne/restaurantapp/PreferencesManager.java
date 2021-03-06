package com.example.manne.restaurantapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by manne on 18.12.2017.
 */

public class PreferencesManager {
    public static void addRestaurants(RestoranData user, Context c){
        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        getPreferences(c).edit().putString("restaurants", mapString).apply();
    }

    public static RestoranData getRestaurants(Context c){
        return new Gson().fromJson(getPreferences(c).getString("restaurants", restorans), RestoranData.class);
    }

    private  static SharedPreferences getPreferences(Context c){
        return c.getApplicationContext().getSharedPreferences("MySharedPreferences", MainActivity.MODE_PRIVATE);
    }

    public static String restorans = "{\"restaurants\": [\n" +
            "  {\n" +
            "    \"logo\": \"https://en.opensuse.org/images/4/49/Amarok-logo-small.png\",\n" +
            "    \"city\": \"Skopje\",\n" +
            "    \"name\": \"Vijayawada\",\n" +
            "    \"rating\": \"2.5\",\n" +
            "    \"menu\": [\n" +
            "      {\n" +
            "        \"link\": \"https://www.asweetpeachef.com/wp-content/uploads/2015/01/easy-soup-recipes-cream-of-fresh-tomato-soup.jpg\",\n" +
            "        \"price\": \"90\",\n" +
            "        \"foodname\": \"Cream Of Tomato Soup\",\n" +
            "        \"isveg\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"https://www.yummytummyaarthi.com/wp-content/uploads/2014/12/1-29.jpg\",\n" +
            "        \"price\": \"90\",\n" +
            "        \"foodname\": \"Veg Clear Soup\",\n" +
            "        \"isveg\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://4.bp.blogspot.com/-x2cj1vawPsM/Vhe98Uq-w1I/AAAAAAADsZ0/xzE4SmoB56A/s1600/1.JPG\",\n" +
            "        \"price\": \"90\",\n" +
            "        \"foodname\": \"Veg Hot &amp; Sour Soup\",\n" +
            "        \"isveg\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://3.bp.blogspot.com/-4LYA-Q52vQo/UiGm0Y2LBbI/AAAAAAAABtk/G9cy-7h9WhU/s1600/Veg+Manchow+Soup.jpg\",\n" +
            "        \"price\": \"90\",\n" +
            "        \"foodname\": \"Veg Manchow Soup\",\n" +
            "        \"isveg\": true\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"logo\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_0IJ5KOkyqxWR2ejXDfI-zIu7aaz23UXO2538oClwzA4mqtiA\",\n" +
            "    \"city\": \"Skopje\",\n" +
            "    \"name\": \"Skopski Merak\",\n" +
            "    \"rating\": \"3.5\",\n" +
            "    \"menu\": [\n" +
            "      {\n" +
            "        \"link\": \"https://moirecepti.mk/content/uploads/2015/01/pastrmajlija1-435c02.png\",\n" +
            "        \"price\": \"190\",\n" +
            "        \"foodname\": \"Пастрмајлија Свинска\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.delposto.mk/wp-content/uploads/2014/12/KGP_6050pileska-pastrmalija-512x298.jpg\",\n" +
            "        \"price\": \"180\",\n" +
            "        \"foodname\": \"Пастрмајлија Пилешка\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://plazadetoros.mk/wp-content/uploads/2014/11/pastrmajlii11.jpg\",\n" +
            "        \"price\": \"220\",\n" +
            "        \"foodname\": \"Пастрмајлија Вегетерјанска\",\n" +
            "        \"isveg\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://moemeni.mk/wp-content/uploads/2017/03/dhiger-vo-sos-od-magdonos-i-luk.jpg\",\n" +
            "        \"price\": \"250\",\n" +
            "        \"foodname\": \"Телешки џигер\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.makedonskatrpeza.com/wp-content/uploads/2014/12/turli-tava-1361x850.jpg\",\n" +
            "        \"price\": \"330\",\n" +
            "        \"foodname\": \"Турли Тава\",\n" +
            "        \"isveg\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "{\n" +
            "    \"logo\": \"http://bravos.mk/img/bc-logos.png\",\n" +
            "    \"city\": \"Skopje\",\n" +
            "    \"name\": \"Бравос\",\n" +
            "    \"rating\": \"4.5\",\n" +
            "    \"menu\": [\n" +
            "      {\n" +
            "        \"link\": \"http://bravos.mk/img/wel-2.png\",\n" +
            "        \"price\": \"200\",\n" +
            "        \"foodname\": \"Капричиоза Пица\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://bravos.mk/img/wel-2.png\",\n" +
            "        \"price\": \"210\",\n" +
            "        \"foodname\": \"Вегетерјанска Пица\",\n" +
            "        \"isveg\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://bravos.mk/img/wel-2.png\",\n" +
            "        \"price\": \"210\",\n" +
            "        \"foodname\": \"Кулен Пица\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://mama365.mk/wp-content/uploads/2017/09/Cezar_salata-PILETINA.jpg\",\n" +
            "        \"price\": \"160\",\n" +
            "        \"foodname\": \"Цезар Салата\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://images.idividi.com.mk/images/tuna31.jpg\",\n" +
            "        \"price\": \"190\",\n" +
            "        \"foodname\": \"Туна Салата\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://bravos.mk/img/bravos-flyer-min.jpg\",\n" +
            "        \"price\": \"150\",\n" +
            "        \"foodname\": \"Сендвич Со Бечка\",\n" +
            "        \"isveg\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "{\n" +
            "    \"logo\": \"http://www.kineskirestoran.com.mk/Images/logo2.png\",\n" +
            "    \"city\": \"Skopje\",\n" +
            "    \"name\": \"Sвезден Океан\",\n" +
            "    \"rating\": \"4.1\",\n" +
            "    \"menu\": [\n" +
            "      {\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/22_23.JPG\",\n" +
            "        \"price\": \"220\",\n" +
            "        \"foodname\": \"Кинеска Салата\",\n" +
            "        \"isveg\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/141_2005.png\",\n" +
            "        \"price\": \"100\",\n" +
            "        \"foodname\": \"Лута Салата со Зелка\",\n" +
            "        \"isveg\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/40_30.JPG\",\n" +
            "        \"price\": \"230\",\n" +
            "        \"foodname\": \"Пржени Пилешки Крилца\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/49_%D0%A1%D0%B2%D0%B8%D0%BD%D1%81%D0%BA%D0%BE%20%D0%B2%D0%BE%20%D0%B3%D1%80%D0%BD%D0%B5%20_svinsko-vo-grne.png\",\n" +
            "        \"price\": \"390\",\n" +
            "        \"foodname\": \"Свинско Во Грне\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/98_81.JPG\",\n" +
            "        \"price\": \"170\",\n" +
            "        \"foodname\": \"Шпагети со ракчиња\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/99_80.JPG\",\n" +
            "        \"price\": \"230\",\n" +
            "        \"foodname\": \"Нудли со Пилешко\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/69_112.JPG\",\n" +
            "        \"price\": \"170\",\n" +
            "        \"foodname\": \"Ориз со Ракчиња\",\n" +
            "        \"isveg\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "{\n" +
            "    \"logo\": \"https://seeklogo.com/images/M/mcdonald-s-logo-7553424BEB-seeklogo.com.png\",\n" +
            "    \"city\": \"Cologne\",\n" +
            "    \"name\": \"McDonald’s\",\n" +
            "    \"rating\": \"4.7\",\n" +
            "    \"menu\": [\n" +
            "      {\n" +
            "        \"link\": \"http://www.frugalfeeds.com.au/wp-content/uploads/2016/05/hero_pdt_hamburger.png\",\n" +
            "        \"price\": \"1€\",\n" +
            "\t   \"foodname\": \"Hamburger\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"https://mcdonalds.co.nz/sites/mcdonalds.co.nz/files/hero_pdt_cheeseburger.png\",\n" +
            "        \"price\": \"1.39€\",\n" +
            "        \"foodname\": \"Cheeseburger\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"https://www.mcdonalds.co.za/sites/default/files/productThumbnail/mcd-food-chicken-mcchicken-burger.png\",\n" +
            "        \"price\": \"1.39€\",\n" +
            "        \"foodname\": \"Chicken Burger\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://929thebull.com/files/2013/02/mcdouble.png\",\n" +
            "        \"price\": \"2.29€\",\n" +
            "        \"foodname\": \"Double Cheeseburger\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"https://www.mcdonaldsarabia.com/content/dam/Arabia/Products/Hero/Veggie-Burger.png\",\n" +
            "        \"price\": \"2.89€\",\n" +
            "        \"foodname\": \"Veggie Burger\",\n" +
            "        \"isveg\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://3.bp.blogspot.com/-FQ9bXMhUMks/VBepKI81eAI/AAAAAAAAAlQ/28hM4k6beaM/s1600/McChickenClassic-Austria-Luxem-Germ.png\",\n" +
            "        \"price\": \"3.89€\",\n" +
            "        \"foodname\": \"McChicken Classic\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"https://www.thedailymeal.com/sites/default/files/story/2017/RAW_McRib.png\",\n" +
            "        \"price\": \"3.89€\",\n" +
            "        \"foodname\": \"McRib\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.mcd.lt/sites/default/files/produits/quarter-pounder.png\",\n" +
            "        \"price\": \"3.89€\",\n" +
            "        \"foodname\": \"Royal Cheese\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"https://i.pinimg.com/originals/7c/90/d5/7c90d52cfa4204cb68a1105a5adb55cd.jpg\",\n" +
            "        \"price\": \"4.19€\",\n" +
            "        \"foodname\": \"Royal TS\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://www.mcdonalds.ie/iehome/food/full_menu/beef/big_tasty_with_bacon/_jcr_content/genericpagecontent/columncontrol/columncontrol%20column2/everything/image.img.png/1413276460148.png\",\n" +
            "        \"price\": \"5.39€\",\n" +
            "        \"foodname\": \"Big Tasty Bacon\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"https://i.ytimg.com/vi/WxPMOVipR-Q/maxresdefault.jpg\",\n" +
            "        \"price\": \"5.49€\",\n" +
            "        \"foodname\": \"Big Double Western\",\n" +
            "        \"isveg\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"link\": \"http://terapiadoluxo.com.br/wp-content/uploads/2015/11/signature-collection.jpg\",\n" +
            "        \"price\": \"5.59€\",\n" +
            "        \"foodname\": \"Signature Collection\",\n" +
            "        \"isveg\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]}\n";

}
