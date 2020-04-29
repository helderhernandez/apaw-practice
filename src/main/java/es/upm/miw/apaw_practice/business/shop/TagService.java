package es.upm.miw.apaw_practice.business.shop;

import es.upm.miw.apaw_practice.data.shop.daos.ShoppingCartRepository;
import es.upm.miw.apaw_practice.data.shop.daos.TagRepository;
import es.upm.miw.apaw_practice.data.shop.dtos.TagDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import es.upm.miw.apaw_practice.data.shop.entities.ArticleItem;
import es.upm.miw.apaw_practice.rest.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private TagRepository tagRepository;

    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public TagService(TagRepository tagRepository, ShoppingCartRepository shoppingCartRepository) {
        this.tagRepository = tagRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public TagDto read(String id) {
        return new TagDto(this.tagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tag id: " + id))
        );
    }

    public void delete(String id) {
        this.tagRepository.deleteById(id);
    }

    public List<TagDto> findByArticlesInShoppingCarts() {
        List<Article> articles = this.shoppingCartRepository.findAll().stream()
                .flatMap(shoppingCart -> shoppingCart.getArticleItems().stream())
                .map(ArticleItem::getArticle)
                .collect(Collectors.toList());
        return this.tagRepository.findAll().stream()
                .filter(tag -> tag.getArticles().stream().anyMatch(articles::contains))
                .map(TagDto::new)
                .collect(Collectors.toList());
    }
}
