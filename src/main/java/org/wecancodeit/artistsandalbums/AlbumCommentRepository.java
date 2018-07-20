package org.wecancodeit.artistsandalbums;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumCommentRepository extends CrudRepository<AlbumComment, Long> {

}
