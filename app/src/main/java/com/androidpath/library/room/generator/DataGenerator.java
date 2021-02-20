/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.androidpath.library.room.generator;

import com.androidpath.library.room.entity.CommentEntity;
import com.androidpath.library.room.entity.ProductEntity;
import com.androidpath.library.room.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Generates data to pre-populate the database
 */
public class DataGenerator {

//    private static final String[] FIRST = new String[]{
//            "Special edition", "New", "Cheap", "Quality", "Used"};
//    private static final String[] SECOND = new String[]{
//            "Three-headed Monkey", "Rubber Chicken", "Pint of Grog", "Monocle"};
//    private static final String[] DESCRIPTION = new String[]{
//            "is finally here", "is recommended by Stan S. Stanman",
//            "is the best sold product on Mêlée Island", "is \uD83D\uDCAF", "is ❤️", "is fine"};

    private static final String[] FIRST = new String[]{
            "小尺寸", "新款", "便宜", "高品质", "好多人用"};

    private static final String[] SECOND = new String[]{
            "电饭锅", "烤鸡翅", "热狗", "衣服"};
    private static final String[] DESCRIPTION = new String[]{
            "真的好", "特别好",
            "最好的", "是 \uD83D\uDCAF", "好 ❤️", "你好"};

    private static final String[] COMMENTS = new String[]{
            "评论 1", "评论 2", "评论 3", "评论 4", "评论 5", "评论 6"};

    public static List<ProductEntity> generateProducts() {
        List<ProductEntity> products = new ArrayList<>(FIRST.length * SECOND.length);
        Random rnd = new Random();
        for (int i = 0; i < FIRST.length; i++) {
            for (int j = i;i + 1<SECOND.length?j < i + 1:j<SECOND.length; j++) {
//            for (int j = i; j < SECOND.length; j++) {
                ProductEntity product = new ProductEntity();
                product.setName(FIRST[i] + " " + SECOND[j]);
                product.setDescription(product.getName() + " " + DESCRIPTION[j]);
                product.setPrice(rnd.nextInt(240));
                product.setId(FIRST.length * i + j + 1);
                products.add(product);
            }
        }
        return products;
    }

    public static List<CommentEntity> generateCommentsForProducts(
            final List<ProductEntity> products) {
        List<CommentEntity> comments = new ArrayList<>();
        Random rnd = new Random();

        for (Product product : products) {
            int commentsNumber = rnd.nextInt(5) + 1;
            for (int i = 0; i < commentsNumber; i++) {
                CommentEntity comment = new CommentEntity();
                comment.setProductId(product.getId());
                comment.setText(COMMENTS[i] + " for " + product.getName());
                comment.setPostedAt(new Date(System.currentTimeMillis()
                        - TimeUnit.DAYS.toMillis(commentsNumber - i) + TimeUnit.HOURS.toMillis(i)));
                comments.add(comment);
            }
        }

        return comments;
    }
}
