package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();

        Post newPost = new Post(1, "queen");
        store.savePost(newPost);
        Post post = store.findPostById(1);
        System.out.println(post);
        store.savePost(new Post(1, "alina"));
        System.out.println(store.findAllPosts().stream().map(p -> {
            StringJoiner joiner = new StringJoiner("***");
            return joiner.add(String.valueOf(p.getId())).add(p.getName()).toString();
        }).collect(Collectors.joining(System.lineSeparator(), "[", "]")));
    }
}