package org.news.dao;

import java.util.List;
import org.news.entity.News;

public interface NewsDao {

   List getAllnews();

   List getAllnewsByTID(int var1);

   int getNewsCountByTID(int var1);

   void add(News var1);
   
   void deleteById(int id);
   
   News getById(int id);
   
   void update(News n);
}
