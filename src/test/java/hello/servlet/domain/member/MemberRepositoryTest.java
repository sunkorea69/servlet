package hello.servlet.domain.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {

        //given 이런게 주어졋을때
        Member member = new Member("hello", 10);

        //when 이런게 실행했을때
        Member saveMember = memberRepository.save(member);

        //then 결과가 이럴때
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);
    }
    @Test
    void findAll() {
        //giben
        Member member1 = new Member("hello1", 20);
        Member member2 = new Member("hello2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2);

    }

}
