package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Override
	 public void run(String... args) throws Exception {
	     Categoria cat1 = new Categoria(null, "Informática");
	     Categoria cat2 = new Categoria(null, "Escritório");
	 
	     Produto p1 = new Produto(null, "Computador", 2000.00);
	     Produto p2 = new Produto(null, "Impressora", 800.00);
	     Produto p3 = new Produto(null, "Mouse", 80.00);
	     
	     cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	     cat2.getProdutos().addAll(Arrays.asList(p2));
	     
	     p1.getCategorias().addAll(Arrays.asList(cat1));
	     p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	     p3.getCategorias().addAll(Arrays.asList(cat1));
	     
	     categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	     produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	     
	     Estado est1 = new Estado(null,"Minas Gerais");
	     Estado est2 = new Estado(null,"São Paulo");
	     
	     Cidade cid1 = new Cidade(null,"Uberlândia",est1);
	     Cidade cid2 = new Cidade(null,"São Paulo",est2);
	     Cidade cid3 = new Cidade(null,"Campinas",est2);
	     
	     est1.getCidades().addAll(Arrays.asList(cid1));
	     est1.getCidades().addAll(Arrays.asList(cid2,cid3));
	     
	     estadoRepository.saveAll(Arrays.asList(est1,est2));
	     cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));

	     
	}

}
