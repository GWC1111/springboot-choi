package net.likelion.bebc25.homework.member.service;

import net.likelion.bebc25.homework.member.dto.MemberDto;
import net.likelion.bebc25.homework.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MemberService 인터페이스의 비즈니스 로직을 처리하는 기본 구현 클래스입니다.
 */
@Service
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  /**
   * 생성자를 통해 MemberRepository 의존성을 주입받습니다.
   *
   * @param memberRepository 주입받을 MemberRepository 스프링 빈 객체
   */
  public MemberServiceImpl(@Qualifier("jdbcTemplateMemberRepository") MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean register(MemberDto member) {
    // member의 username이 데이터베이스에 존재하지 않을 경우 회원가입 허용 (중복된 username으로 회원가입 불가)
    if(memberRepository.findByUsername(member.getUsername()) == null) {
      memberRepository.save(member);
      return true;
    } else {
      return false;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MemberDto login(String username, String password) {
    MemberDto member = memberRepository.findByUsername(username);

    // 존재하지 않는 username일 경우
    if (member == null) {
      return null;
    }

    // password가 일치할 경우
    if(member.getPassword().equals(password)) {
      return member;
    } else {
      // password가 일치하지 않을 경우
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void modifyInfo(MemberDto member) {
    // 실습 영역
    memberRepository.update(member);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void withdraw(int id) {
    // 실습 영역
    memberRepository.deleteById(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<MemberDto> getMembers() {
    return memberRepository.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MemberDto getMember(int id) {
    return memberRepository.findById(id);
  }
}
