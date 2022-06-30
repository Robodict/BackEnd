package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member, Member ps);
    Optional<Member> findById(Long id);
    Optional<Member> findByname(String name);
    Optional<Member> findByPassword(String Password);
    List<Member> findAll();
}

