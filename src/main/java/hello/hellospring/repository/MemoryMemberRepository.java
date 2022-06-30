package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements  MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static Map<Member, Member> ps = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public Member save(Member member, Member pss) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        ps.put(member, pss);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByname(String name) {
       return store.values().stream().filter(member -> member.getName().equals(name) ).findAny();

    }

    @Override
    public Optional<Member> findByPassword(String name) {
        return Optional.ofNullable(ps.get(name));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
