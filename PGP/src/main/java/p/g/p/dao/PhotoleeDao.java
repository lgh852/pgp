package p.g.p.dao;

import java.util.List;

import p.g.p.model.Like;
import p.g.p.model.PhotoListmodel;

public interface PhotoleeDao {
   
   public List<PhotoListmodel> photolist( PhotoListmodel photolist);
   public List<PhotoListmodel> photolistcnt( PhotoListmodel photolist);
   public List<PhotoListmodel> photolistlike( PhotoListmodel photolist);
   public int likeUp(Like like);
   public Like selectlikeck(Like like);
   public int deletelike(Like like);
   public int likeupdatUp(Like like);
   public int likeupdatDown(Like like);
   public List<Like> seleteimg(Like like);
   
   
}