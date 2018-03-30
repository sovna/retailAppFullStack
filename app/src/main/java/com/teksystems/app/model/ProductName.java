package com.teksystems.app.model;

/**
 * Created by sopani on 3/30/2018.
 */

public enum ProductName {
    P501(501, "Tomato"),
    P502(502, "Potato"),
    P503(503, "Brinjal"),
    P504(504, "Apples"),
    P505(505, "Oranges"),
    P506(506, "Banana"),
    P507(507, "Papaya"),
    P508(508, "Cabbage"),
    P509(509, "Aashirwaad Chakki Aata"),
    P510(510, "Aashirwaad Multigrain Aata"),
    P511(511, "Aashirwaad Iodized Salt"),
    P512(512, "Aashirwaad Select Aata"),
    P513(513, "Tata Iodized Salt"),
    P514(514, "Tata Chilli Powder"),
    P515(515, "Tata Besan"),
    P516(516, "Tata Turmeric Powder"),
    P517(517, "Freedom Refined Sunflower Oil"),
    P518(518, "Freedom Groundnut Oil"),
    P519(519, "Freedom Coconut Oil"),
    P520(520, "Freedom Olive Oil"),
    P521(521, "MTR Mirchi Powder"),
    P522(522, "MTR Turmeric Powder"),
    P523(523, "MTR Idly Ready Mix"),
    P524(524, "MTR Dosa Ready Mix"),
    P525(525, "Brooke Bond Red Label Tea"),
    P526(526, "Brooke Bond Green Label Coffee"),
    P527(527, "Brooke Bond Instant Coffee"),
    P528(528, "Brooke Bond Green Tea"),
    P529(529, "Taj Mahal Premium Tea"),
    P530(530, "Taj Mahal Green Tea"),
    P531(531, "Taj Mahal Lemon Tea"),
    P532(532, "Taj Mahal Coffee"),
    P533(533, "Pepsi Tin"),
    P534(534, "Pepsi Pet Bottle"),
    P535(535, "Pepsi"),
    P536(536, "Pepsi Jumbo Bottle"),
    P537(537, "Patanjali Tooth Paste"),
    P538(538, "Patanjali Mouth Wash"),
    P539(539, "Patanjali Dishwash Bar"),
    P540(540, "Patanjali Handwash"),
    P541(541, "Harpic Bathroom Cleaner"),
    P542(542, "Harpic Tiles Cleaner"),
    P543(543, "Harpic Mini Pack"),
    P544(544, "Harpic Jumbo Pack"),
    P545(545, "Surf Excel Easy Wash"),
    P546(546, "Surf Excel Bar"),
    P547(547, "Surf Excel Matic"),
    P548(548, "Surf Excel Liquid"),
    P549(549, "The Body Shop Soap"),
    P550(550, "The Body Shop Shower Gel"),
    P551(551, "The Body Shop Body Butter"),
    P552(552, "The Body Shop Lip Balm"),
    P553(553, "Lakme Nail Paint"),
    P554(554, "Lakme Iconic Kajal"),
    P555(555, "Lakme Lip Balm"),
    P556(556, "Lakme Lip Stick"),
    P557(557, "Garnier Face Wash"),
    P558(558, "Garnier Shower Gel"),
    P559(559, "Garnier Face Cream"),
    P560(560, "Garnier Shampoo"),
    P561(561, "Amul Milk"),
    P562(562, "Amul Paneer"),
    P563(563, "Amul Butter"),
    P564(564, "Amul Cheese"),
    P565(565, "Heritage Milk"),
    P566(566, "Heritage Paneer"),
    P567(567, "Heritage Butter"),
    P568(568, "Heritage Cheese"),
    P569(569, "Kellogs Chocos"),
    P570(570, "Kellogs Cornflakes"),
    P571(571, "Kellogs Chocos Moons & Stars"),
    P572(572, "Kellogs Oats"),
    P573(573, "Quaker Oats"),
    P574(574, "Quaker Plus Multigrain Oats"),
    P575(575, "Quaker Masala Oats"),
    P576(576, "Quaker Oats Small"),
    P577(577, "Maggie Aata Noodles"),
    P578(578, "Maggie Noodles"),
    P579(579, "Maggie Tomato Sauce"),
    P580(580, "Maggie Hot and Sour Sauce"),
    P581(581, "Yippie Noodles Small"),
    P582(582, "Yippie Noodles Double Pack"),
    P583(583, "Yippie Noodles Masala"),
    P584(584, "Yippie Noodles Family Pack"),
    P585(585, "Johnson Baby Shampoo"),
    P586(586, "Johnson Baby Wash"),
    P587(587, "Johnson Baby Cream"),
    P588(588, "Johnson Baby Powder"),
    P589(589, "Pampers Small pack"),
    P590(590, "Pampers Jumbo Pack"),
    P591(591, "Pampers Baby Dry Pants"),
    P592(592, "Pampers Baby Dry Pants Large"),
    P593(593, "Huggies Small pack"),
    P594(594, "Huggies Jumbo Pack"),
    P595(595, "Huggies Baby Dry Pants"),
    P596(596, "Huggies Baby Dry Pants Large"),
    P597(597, "Pedigree Chicken & Vegetables Dry"),
    P598(598, "Pedigree Chicken in Jelly Wet"),
    P599(599, "Pedrigree Dentastix"),
    P600(600, "Pedigree Denta Tubos");

    private final int key;

    private final String value;

    ProductName(int key, String value) {

        this.key = key;

        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
