package rborodin.skillgram.userservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "follows")
@Entity
public class Follow {

    @EmbeddedId
    private FollowId id;

    @ManyToOne
    @MapsId("followerUserId")
    @JoinColumn(name = "follower_user_id")
    private User followerUser;

    @ManyToOne
    @MapsId("followingUserId")
    @JoinColumn(name = "following_user_id")
    private User followingUser;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    public Follow(User followerUser, User followingUser) {
        this.id = new FollowId(followerUser.getId(), followingUser.getId());
        this.followerUser = followerUser;
        this.followingUser = followingUser;
    }
}
