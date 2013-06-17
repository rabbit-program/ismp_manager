package edu.sjtu.infosec.ismp.manager.comm.comm.search;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

import edu.sjtu.infosec.ismp.manager.OSS.klbm.model.OssKnowledgeBase;

import java.sql.*;

public class LuceneReadMysql {
	@SuppressWarnings("deprecation")
	private static Hits hits=null;
	@SuppressWarnings("unchecked")
	public static List LuceneRead(List list,String query,int startIndex,int endIndex) {
			File indexDir = new File("d:\\indexnew");
			Analyzer luceneAnalyzer = new StandardAnalyzer();
			try {
				IndexWriter indexWriter = new IndexWriter(indexDir,luceneAnalyzer, true,MaxFieldLength.LIMITED);/* 实例一个索引创建器 */
				for(int i=0;i<list.size();i++){
					// 增加document到索引去
					// document对象，相当于数据库中一条记录
					OssKnowledgeBase base = (OssKnowledgeBase) list.get(i);
					Document document = new Document();
					document.add(new Field("id", base.getId()+"",Field.Store.YES, Field.Index.NO));
					document.add(new Field("name", base.getName(),Field.Store.YES, Field.Index.NO));
					document.add(new Field("file_content",base.getFile_content(),Field.Store.YES, Field.Index.ANALYZED));
					document.add(new Field("lastUpdateTime", base.getLastUpdateTime()+"",Field.Store.YES, Field.Index.NO));
					document.add(new Field("sn", base.getSn(),Field.Store.YES, Field.Index.NO));
					document.add(new Field("issuer", base.getIssuer(),Field.Store.YES, Field.Index.NO));
					indexWriter.addDocument(document);/* 加入索引器 */
				}
				indexWriter.optimize(); /* 优化 */
				indexWriter.close(); /* 关闭 */
				
	            hits=search(query);       //输入查询内容后，查询
            	List<OssKnowledgeBase> BeginList = new ArrayList<OssKnowledgeBase>();
            	if(endIndex>=hits.length()){
            		endIndex=hits.length()-1;
            	}else{
            		endIndex=endIndex-1;
            	}
	            for(int i=startIndex;i<=endIndex;i++){ //返回查询后结果
	            	OssKnowledgeBase base = new OssKnowledgeBase();
	                Document document=hits.doc(i);
	                base.setId(Integer.parseInt(document.get("id")));
	                base.setName(document.get("name"));
	                base.setFile_content(document.get("file_content"));
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                base.setLastUpdateTime(new Timestamp(sdf.parse(document.get("lastUpdateTime")).getTime()));
	                base.setSn(document.get("sn"));
	                base.setIssuer(document.get("issuer"));
	                BeginList.add(base);
	            }
	            return BeginList;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	@SuppressWarnings("deprecation")
	public static Hits search(String quString){//搜索用户输入的字符
        try {
			Analyzer luceneAnalyzer = new StandardAnalyzer();
            IndexSearcher iSearcher = new IndexSearcher("d:\\indexnew");
            QueryParser parser=new QueryParser("file_content",luceneAnalyzer);
            Query query=parser.parse(quString);
            hits=iSearcher.search(query);
            return hits;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
	
	@SuppressWarnings("deprecation")
	public static Integer getCount(){//获得总条数
        return hits.length();
    } 
}
