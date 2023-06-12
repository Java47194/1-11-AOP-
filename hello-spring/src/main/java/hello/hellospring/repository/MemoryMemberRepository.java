package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    //저장할곳

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;


    // 번호 자동


    @Override
    public Member Save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;

    }

    @Override
    public Optional<Member> findbyid(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findbyname(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void StoreClear(){
        store.clear();
    }

}