package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 뒤에 안써주면 NullPointException이 터짐
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
