package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member Save(Member member);
    Optional<Member> findbyid(Long id); //ctrl+d 라인복사
    Optional<Member> findbyname(String name);

    List<Member> findAll();



}
